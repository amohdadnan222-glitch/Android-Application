package com.coderbhai.firstone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "UserDB";
    public static final String TABLE_NAME = "users";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT," +
                "password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertUser(String email,String password){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("email",email);
        cv.put("password",password);

        long result=db.insert(TABLE_NAME,null,cv);

        return result!=-1;
    }

    public boolean checkUser(String email,String password){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(
                "SELECT * FROM users WHERE email=? AND password=?",
                new String[]{email,password});

        return cursor.getCount()>0;
    }

}