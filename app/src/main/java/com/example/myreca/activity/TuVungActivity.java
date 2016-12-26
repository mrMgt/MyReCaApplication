package com.example.myreca.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.myreca.adapter.TuVungAdapter;
import com.example.myreca.model.TuVung;

import java.util.List;

/**
 * Created by linhnd on 2016/12/26.
 */

public class TuVungActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<TuVung> tuVungList;
    private TuVungAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

    }

    private void prepareTuvungs() {
        Album a = new Album("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new Album("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        albumList.add(a);

        a = new Album("Legend", 14, covers[7]);
        albumList.add(a);

        a = new Album("Hello", 11, covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();

    }
}
