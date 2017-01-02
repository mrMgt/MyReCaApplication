package com.example.myreca.utils;

import android.content.Context;
import android.util.Log;

import com.example.myreca.model.TuVung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr on 1/1/2017.
 */

public class FileUtils {
    static String LESSON_SOURCE = "";
    static String versionDbInit = "";
    private String TAG = "FileUtils";
    public static List<String> readLessons(Context ct) {
        List<String> results = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(ct.getAssets().open("lessons")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                results.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                    e.printStackTrace();
                }
            }
        }
        return results;
    }

    public static List<TuVung> readVocabularies(Context ct) {
        List<TuVung> results = new ArrayList<>();

        BufferedReader reader = null;
        String strTuvung[];
        TuVung tuVung;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(ct.getAssets().open("vocabulary")));

            // do reading, usually loop until end of file reading
            String mLine;
            int count = 1;
            while ((mLine = reader.readLine()) != null) {

                strTuvung = mLine.split(",");
                Log.i("FileUtils", "strTuvung: " + strTuvung[0]);
                Log.i("FileUtils", "strTuvung: " + strTuvung[1]);
                Log.i("FileUtils", "strTuvung: " + strTuvung[2]);
//                Log.i("FileUtils", "strTuvung: " + strTuvung[3]);
                Log.i("FileUtils", "len: " + strTuvung.length);

                tuVung = new TuVung();
                tuVung.setTuvung_baihocso(null==strTuvung[0]?null:strTuvung[0]);
                tuVung.setTuvung_kanji(null==strTuvung[1]?null:strTuvung[1]);
                tuVung.setTuvung_hira(null==strTuvung[2]?null:strTuvung[2]);
                if (strTuvung.length > 3) {
                    tuVung.setTuvung_nghia(null==strTuvung[3]?null:strTuvung[3]);
                }

                if (strTuvung.length > 4) {
                    tuVung.setTuvung_vidu(null==strTuvung[4]?null:strTuvung[4]);
                }

                Log.i("FileUtils", "Count down: " + count);
                results.add(tuVung);
            }
        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
}
