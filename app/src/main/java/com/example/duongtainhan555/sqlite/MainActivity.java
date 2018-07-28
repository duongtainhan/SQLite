package com.example.duongtainhan555.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static SQLiteDB sqLiteDB;
    RecyclerView recyclerView;
    ArrayList<NhaHang> arrayRes;
    NhaHangAdapter nhaHangAdapter;
    Button btnAddEating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create database
        sqLiteDB = new SQLiteDB(this,"QuanLyNhaHang.sql",null,1);
        //Create table -- TenMonAn --- GiaMonAn -- DiaDiem
        //String create_table = "CREATE TABLE IF NOT EXISTS NhaHang(Id INTEGER PRIMARY KEY AUTOINCREMENT , TenMonAn VARCHAR , GiaMonAn INTEGER , DiaDiem VARCHAR )";
        //sqLiteDB.QueryData(create_table);

        //Add value
        String insert = "INSERT INTO NhaHang VALUES(null, 'Com suon', 25000, 'Quan 10')";
        String insert_1 = "INSERT INTO NhaHang VALUES(null, 'Hu tieu', 20000, 'Quan 1')";
        String insert_2 = "INSERT INTO NhaHang VALUES(null, 'Banh canh', 20000, 'Quan 2')";
        String insert_3 = "INSERT INTO NhaHang VALUES(null, 'Pha lau', 15000, 'Quan 3')";
        //sqLiteDB.QueryData(insert_1);

        btnAddEating = findViewById(R.id.btnAddEating);
        recyclerView = findViewById(R.id.recycle_view);
        arrayRes = new ArrayList<>();
        nhaHangAdapter = new NhaHangAdapter(MainActivity.this,arrayRes);

        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(nhaHangAdapter);


        //Get value
        GetData();

        btnAddEating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThemMonAnActivity.class);
                startActivity(intent);
            }
        });
    }

    public void GetData()
    {
        arrayRes.clear();
        Cursor cursor = sqLiteDB.GetData("SELECT * FROM NhaHang");
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String ten_mon_an = cursor.getString(1);
            int gia_mon_an = cursor.getInt(2);
            String dia_diem = cursor.getString(3);
            arrayRes.add(new NhaHang(id,ten_mon_an,gia_mon_an,dia_diem));
        }
        nhaHangAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onRestart() {
        GetData();
        super.onRestart();
    }
}
