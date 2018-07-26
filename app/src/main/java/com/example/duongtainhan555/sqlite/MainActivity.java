package com.example.duongtainhan555.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDB sqLiteDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create database
        sqLiteDB = new SQLiteDB(this,"QuanLyNhaHang.sql",null,1);
        //Create table -- TenMonAn --- GiaMonAn -- DiaDiem
        String create_table = "CREATE TABLE IF NOT EXISTS NhaHang(Id INTEGER PRIMARY KEY AUTOINCREMENT , TenMonAn VARCHAR , GiaMonAn INTEGER , DiaDiem VARCHAR )";
        sqLiteDB.QueryData(create_table);


    }
}
