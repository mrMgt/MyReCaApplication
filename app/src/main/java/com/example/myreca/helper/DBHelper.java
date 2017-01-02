package com.example.myreca.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

/**
 * Created by mr on 1/1/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "config";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_KEY = "key";
    public static final String CONTACTS_COLUMN_VALUE = "value";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table config " +
                        "(id integer primary key AUTOINCREMENT, key text NOT NULL, value text NOT NULL, )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS version");
        onCreate(db);
    }

    public boolean insertVersion (String key, String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", key);
        contentValues.put("value", value);
        db.insert("config", null, contentValues);
        return true;
    }

    public Cursor getDataByKey(String key) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from config where key=" + key + "", null );
        return res;
    }
}
