package com.example.myreca.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.example.myreca.model.TuVung;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr on 1/1/2017.
 */

public class VocabularyDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyReCaApp.db";
    public static final String VOCABULARY_TABLE_NAME = "vocabulary";
    public static final String VOCABULARY_COLUMN_ID = "id";
    public static final String VOCABULARY_COLUMN_KANJI = "vocabulary_kanji";
    public static final String VOCABULARY_COLUMN_HIRA = "vocabulary_hira";
    public static final String VOCABULARY_COLUMN_EXAMPLE = "vocabulary_example";
    public static final String VOCABULARY_COLUMN_LESSON_NO = "vocabulary_lesson_no";
    public static final String VOCABULARY_COLUMN_MEAN = "vocabulary_mean";
    private String TAG = "VocabularyDBHelper";


    public VocabularyDBHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator+ DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
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
        db.execSQL("DROP TABLE IF EXISTS vocabulary");
        onCreate(db);
    }

    public boolean insertVocabulary (TuVung tuVung) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("vocabulary_kanji", tuVung.getTuvung_kanji());
        contentValues.put("vocabulary_hira", tuVung.getTuvung_hira());
        contentValues.put("vocabulary_example", tuVung.getTuvung_vidu());
        contentValues.put("vocabulary_lesson_no", tuVung.getTuvung_baihocso());
        contentValues.put("vocabulary_mean", tuVung.getTuvung_nghia());
        db.insert("vocabulary", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from vocabulary where id=" + id + "", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, VOCABULARY_TABLE_NAME);
        return numRows;
    }

    public boolean updateVocabulary (TuVung tuVung) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("vocabulary_kanji", tuVung.getTuvung_kanji());
        contentValues.put("vocabulary_hira", tuVung.getTuvung_hira());
        contentValues.put("vocabulary_example", tuVung.getTuvung_vidu());
        contentValues.put("vocabulary_lesson_no", tuVung.getTuvung_baihocso());
        contentValues.put("vocabulary_mean", tuVung.getTuvung_nghia());
        db.update("vocabulary", contentValues, "id = ? ", new String[] { Integer.toString(tuVung.getId()) } );
        return true;
    }

    public void deleteVocabulary () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete From vocabulary");
    }



    public List<TuVung> getAllVocabulary() {
        List<TuVung> vocabularys = new ArrayList<TuVung>();
        TuVung tuVung;

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from vocabulary", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            tuVung = new TuVung();
            tuVung.setId(res.getInt(res.getColumnIndex(VOCABULARY_COLUMN_ID)));
            tuVung.setTuvung_kanji(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_KANJI)));
            tuVung.setTuvung_hira(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_HIRA)));
            tuVung.setTuvung_vidu(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_EXAMPLE)));
            tuVung.setTuvung_baihocso(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_LESSON_NO)));
            tuVung.setTuvung_nghia(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_MEAN)));
            vocabularys.add(tuVung);

            res.moveToNext();
        }

        return vocabularys;
    }


    public List<TuVung> getAllVocabularyByLessonNo(String lessonNo) {
        List<TuVung> vocabularys = new ArrayList<TuVung>();
        TuVung tuVung;

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from vocabulary where vocabulary_lesson_no= " + lessonNo +"", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            tuVung = new TuVung();
            tuVung.setId(res.getInt(res.getColumnIndex(VOCABULARY_COLUMN_ID)));
            tuVung.setTuvung_kanji(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_KANJI)));
            tuVung.setTuvung_hira(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_HIRA)));
            tuVung.setTuvung_vidu(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_EXAMPLE)));
            tuVung.setTuvung_baihocso(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_LESSON_NO)));
            tuVung.setTuvung_nghia(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_MEAN)));
            vocabularys.add(tuVung);

            res.moveToNext();
        }

        return vocabularys;
    }


    public boolean insertDbPrepare (List<TuVung> vocabularies) {
        int count = 0;
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();


            for (TuVung item : vocabularies) {
                contentValues.put("vocabulary_kanji", item.getTuvung_kanji());
                contentValues.put("vocabulary_hira", item.getTuvung_hira());
                contentValues.put("vocabulary_example", item.getTuvung_vidu());
                contentValues.put("vocabulary_lesson_no", item.getTuvung_baihocso());
                contentValues.put("vocabulary_mean", item.getTuvung_nghia());
                db.insert("vocabulary", null, contentValues);
                count++;
            }

        } catch (Exception ex) {
            Log.i(TAG, ex.getMessage());
        }

        Log.i(TAG, "COUNT: " + count);

        return true;
    }
}
