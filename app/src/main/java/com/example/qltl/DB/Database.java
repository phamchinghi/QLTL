package com.example.qltl.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //khong tra ket qua: insert, delete, update, create
    public  void QueryData(String sql){
        SQLiteDatabase dataBase = getWritableDatabase();
        dataBase.execSQL(sql);
    }
    //tra du lieu
    public Cursor getData(String sql){
        SQLiteDatabase dataBase = getReadableDatabase();
        return dataBase.rawQuery(sql, null);
    }
}
