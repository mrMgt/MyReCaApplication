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
import com.example.myreca.model.TuVung;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mr on 1/1/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";

    public static final String LESSONS_TABLE_NAME = "lesson";
    public static final String LESSONS_COLUMN_ID = "id";
    public static final String LESSONS_COLUMN_BAIHOCSO = "lessonNo";

    public static final String VOCABULARY_TABLE_NAME = "vocabulary";
    public static final String VOCABULARY_COLUMN_ID = "id";
    public static final String VOCABULARY_COLUMN_KANJI = "vocabulary_kanji";
    public static final String VOCABULARY_COLUMN_HIRA = "vocabulary_hira";
    public static final String VOCABULARY_COLUMN_EXAMPLE = "vocabulary_example";
    public static final String VOCABULARY_COLUMN_LESSON_ID = "vocabulary_lesson_id";
    public static final String VOCABULARY_COLUMN_MEAN = "vocabulary_mean";


    private static final String CREATE_TABLE_LESSON = "CREATE TABLE lesson " +
            "(id integer primary key AUTOINCREMENT, lessonNo text NOT NULL)";
    private static final String CREATE_TABLE_VOCABULARY = "CREATE TABLE vocabulary " +
            "(" +
            "id integer primary key AUTOINCREMENT, " +
            "vocabulary_kanji text NOT NULL, " +
            "vocabulary_hira text NOT NULL, " +
            "vocabulary_example text NOT NULL, " +
            "vocabulary_lesson_id text NOT NULL, " +
            "vocabulary_mean text NOT NULL" +
            ")";

    private String TAG = "DBHelper";



    public DBHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory()
                + File.separator+ DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LESSON);
        db.execSQL(CREATE_TABLE_VOCABULARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS lesson");
        db.execSQL("DROP TABLE IF EXISTS vocabulary");

        onCreate(db);
    }

    public long insertLesson (String lessonNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("lessonNo", lessonNo);
        return db.insert("lesson", null, contentValues);
    }

    public Cursor getLessonById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from lesson where id=" + id + "", null );
        return res;
    }

    public int numberOfLesson(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, LESSONS_TABLE_NAME);
        return numRows;
    }

    public int updateLesson (ChuongTrinhHoc chuongTrinhHoc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("lessonNo", chuongTrinhHoc.getBaihocso());
        return db.update("lesson", contentValues, "id = ? ", new String[]{Integer.toString(chuongTrinhHoc.getId())} );
    }

    public void deleteLesson () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete From lesson");
    }

    public List<ChuongTrinhHoc> getAllLesson() {
        List<ChuongTrinhHoc> lessons = new ArrayList<ChuongTrinhHoc>();
        ChuongTrinhHoc chuongTrinhHoc;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from lesson", null );
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

    public boolean prepareDataLesson (List<String> lessonNo) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            int count = 0;

            for (String item : lessonNo) {
                contentValues.put("lessonNo", item);
                db.insert("lesson", null, contentValues);
                count++;
            }

        } catch (Exception ex) {
            Log.i("", ex.getMessage());
        }

        return true;
    }

    // Vocabulary area
    public long insertVocabulary (TuVung tuVung) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("vocabulary_kanji", tuVung.getTuvung_kanji());
        contentValues.put("vocabulary_hira", tuVung.getTuvung_hira());
        contentValues.put("vocabulary_example", tuVung.getTuvung_vidu());
        contentValues.put("vocabulary_lesson_id", tuVung.getTuvung_baihocso());
        contentValues.put("vocabulary_mean", tuVung.getTuvung_nghia());
        return db.insert("vocabulary", null, contentValues);
    }

    public Cursor getVocabularyById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from vocabulary where id=" + id + "", null );
        return res;
    }

    public int numberOfVocabulary(){
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
        contentValues.put("vocabulary_lesson_id", tuVung.getTuvung_baihocso());
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

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from vocabulary", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            tuVung = new TuVung();
            tuVung.setId(res.getInt(res.getColumnIndex(VOCABULARY_COLUMN_ID)));
            tuVung.setTuvung_kanji(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_KANJI)));
            tuVung.setTuvung_hira(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_HIRA)));
            tuVung.setTuvung_vidu(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_EXAMPLE)));
            tuVung.setTuvung_baihocso(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_LESSON_ID)));
            tuVung.setTuvung_nghia(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_MEAN)));
            vocabularys.add(tuVung);

            res.moveToNext();
        }

        return vocabularys;
    }

    public List<TuVung> getVocabularysByLessonNo(String lessonId) {
        List<TuVung> vocabularys = new ArrayList<TuVung>();
        TuVung tuVung;

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from vocabulary where vocabulary_lesson_id= " + lessonId +"", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            tuVung = new TuVung();
            tuVung.setId(res.getInt(res.getColumnIndex(VOCABULARY_COLUMN_ID)));
            tuVung.setTuvung_kanji(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_KANJI)));
            tuVung.setTuvung_hira(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_HIRA)));
            tuVung.setTuvung_vidu(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_EXAMPLE)));
            tuVung.setTuvung_baihocso(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_LESSON_ID)));
            tuVung.setTuvung_nghia(res.getString(res.getColumnIndex(VOCABULARY_COLUMN_MEAN)));
            vocabularys.add(tuVung);

            res.moveToNext();
        }

        return vocabularys;
    }

    public boolean prepareVocabulary (List<TuVung> vocabularies) {
        int count = 0;
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();


            for (TuVung item : vocabularies) {
                contentValues.put("vocabulary_kanji", item.getTuvung_kanji());
                contentValues.put("vocabulary_hira", item.getTuvung_hira());
                contentValues.put("vocabulary_example", item.getTuvung_vidu());
                contentValues.put("vocabulary_lesson_id", item.getTuvung_baihocso());
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

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public void prepareAllData(List<String> sqlData) {
        SQLiteDatabase db = this.getReadableDatabase();
        //drop table
        db.execSQL("DROP TABLE IF EXISTS lesson");
        db.execSQL("DROP TABLE IF EXISTS vocabulary");

        onCreate(db);

        for (String item : sqlData) {
            db.execSQL(item);
        }
        closeDB();
    }
}
