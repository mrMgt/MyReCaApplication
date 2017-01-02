package com.example.myreca.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myreca.R;
import com.example.myreca.helper.ChuongTrinhHocDBHelper;
import com.example.myreca.helper.DBHelper;
import com.example.myreca.helper.VocabularyDBHelper;
import com.example.myreca.model.ChuongTrinhHoc;
import com.example.myreca.model.TuVung;
import com.example.myreca.utils.FileUtils;

import java.util.List;

public class MyReCaActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    private DBHelper dbHelper;

    private static boolean isDataInit = false;
    private Button btnLesson;
    private Button btnVocabulary;
    private Button btnImages;
    private Button btnSettingData;
    private Button btnInfinityScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myreca);
        btnLesson = (Button) findViewById(R.id.btnChuongTrinhHoc);
        btnVocabulary = (Button) findViewById(R.id.btnTuVung);
        btnImages = (Button) findViewById(R.id.btnLoadImage);
        btnSettingData = (Button) findViewById(R.id.btnSettingData);
        btnInfinityScroll = (Button) findViewById(R.id.btnInfinityScroll);

        btnLesson.setOnClickListener(this);
        btnVocabulary.setOnClickListener(this);
        btnImages.setOnClickListener(this);
        btnSettingData.setOnClickListener(this);
        btnInfinityScroll.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnChuongTrinhHoc:
                intent = new Intent(this, ChuongTrinhHocActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTuVung:
                intent = new Intent(this, TuVungActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLoadImage:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSettingData:
                settingData();
                break;
            case R.id.btnInfinityScroll:
                intent = new Intent(this, InfinityScrollActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    /**
     * Set up data
     */
    private void setupDb() {

        List<String> lessons = FileUtils.readLessons(this);
        List<TuVung> vocabularys = FileUtils.readVocabularies(this);
        dbHelper = new DBHelper(this);

        //chua khoi tao data
        if (!isDataInit) {
            dbHelper.deleteLesson();
            dbHelper.prepareDataLesson(lessons);

            dbHelper.deleteVocabulary();
            dbHelper.prepareVocabulary(vocabularys);

            isDataInit = true;
            //notification
            Toast.makeText(this, "Prepare data success", Toast.LENGTH_LONG).show();
        }
    }

    private void settingData() {
        dbHelper = new DBHelper(this);
        List<String> sqlData = FileUtils.settingData(this);


        dbHelper.prepareAllData(sqlData);
        Toast.makeText(this, "Prepare data success", Toast.LENGTH_LONG).show();
    }

}
