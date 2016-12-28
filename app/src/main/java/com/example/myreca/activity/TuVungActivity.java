package com.example.myreca.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myreca.R;
import com.example.myreca.adapter.AlbumsAdapter;
import com.example.myreca.adapter.TuVungAdapter;
import com.example.myreca.model.Album;
import com.example.myreca.model.TuVung;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linhnd on 2016/12/26.
 */

public class TuVungActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<TuVung> tuVungList;
    private TuVungAdapter adapter;
    private TuVung tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuvung_activity);

        recyclerView = (RecyclerView) findViewById(R.id.tuvung_recycler_view);

        tuVungList = new ArrayList<>();
        adapter = new TuVungAdapter(this, tuVungList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareTuvungs();
    }

    private void prepareTuvungs() {
        tv = new TuVung("展覧会","てんらんかい","昨日、絵の展覧会に　行ってきました");
        tuVungList.add(tv);
        tv = new TuVung("開きます","ひらきます","大阪で　展覧会が　開かれます");
        tuVungList.add(tv);

        tv = new TuVung("行います","おこないます","大阪で　国際会議が　行われます");
        tuVungList.add(tv);

        tv = new TuVung("壊します","こわします","この　美術館は　来月　壊されます");
        tuVungList.add(tv);

        tv = new TuVung("輸出します","ゆしゅつします","日本の　車は　いろいろな　国へ　輸出されて　います");
        tuVungList.add(tv);

        tv = new TuVung("組み立てます","くみたてます","洗濯機は　この　工場で　組み立てられて　います");
        tuVungList.add(tv);

        adapter.notifyDataSetChanged();

    }
}
