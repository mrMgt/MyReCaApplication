package com.example.myreca.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.example.myreca.model.ChuongTrinhHoc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mr on 1/1/2017.
 */

public class ChuongTrinhHocDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyReCaApp.db";
    public static final String LESSONS_TABLE_NAME = "chuongtrinhhoc";
    public static final String LESSONS_COLUMN_ID = "id";
    public static final String LESSONS_COLUMN_BAIHOCSO = "baihocso";

    public ChuongTrinhHocDBHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator+ DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table chuongtrinhhoc " +
                        "(id integer primary key AUTOINCREMENT, baihocso text NOT NULL)"
        );

        db.execSQL(
                "create table vocabulary " +
                        "(" +
                        "id integer primary key AUTOINCREMENT, " +
                        "vocabulary_kanji text NOT NULL, " +
                        "vocabulary_hira text NOT NULL," +
                        "vocabulary_example text NOT NULL" +
                        "vocabulary_lesson_no text NOT NULL" +
                        "vocabulary_mean text NOT NULL" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS chuongtrinhhoc");
        onCreate(db);
    }

    public boolean insertChuongTrinhHoc (String baihocso) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("baihocso", baihocso);
        db.insert("chuongtrinhhoc", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from chuongtrinhhoc where id=" + id + "", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, LESSONS_TABLE_NAME);
        return numRows;
    }

    public boolean updateChuongTrinhHoc (Integer id, String baihocso) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("baihocso", baihocso);
        db.update("chuongtrinhhoc", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public void deleteChuongTrinhHoc () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete From chuongtrinhhoc");
    }

    public List<ChuongTrinhHoc> getAllChuongTrinhHoc() {
//        ArrayList<String> array_list = new ArrayList<String>();
        List<ChuongTrinhHoc> lessons = new ArrayList<ChuongTrinhHoc>();
        ChuongTrinhHoc chuongTrinhHoc;

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from chuongtrinhhoc", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            chuongTrinhHoc = new ChuongTrinhHoc();
            chuongTrinhHoc.setId(res.getInt(res.getColumnIndex(LESSONS_COLUMN_ID)));
            chuongTrinhHoc.setBaihocso(res.getString(res.getColumnIndex(LESSONS_COLUMN_BAIHOCSO)));
            lessons.add(chuongTrinhHoc);

            res.moveToNext();
        }

        return lessons;
    }

    public boolean insertDbPrepare (List<String> baihocso) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            int count = 0;

            for (String item : baihocso) {
                contentValues.put("baihocso", item);
                db.insert("chuongtrinhhoc", null, contentValues);
                count++;
            }

        } catch (Exception ex) {
            Log.i("", ex.getMessage());
        }

        return true;
    }

}
