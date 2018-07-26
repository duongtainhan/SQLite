package com.example.duongtainhan555.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    SQLiteDB sqLiteDB;
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
        //sqLiteDB.QueryData(insert_3);

        //Get value
        Cursor cursor = sqLiteDB.GetData("SELECT * FROM NhaHang");
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String ten_mon_an = cursor.getString(1);
            int gia_mon_an = cursor.getInt(2);
            String dia_diem = cursor.getString(3);
            Log.d("BBB",ten_mon_an);
        }
    }
}
