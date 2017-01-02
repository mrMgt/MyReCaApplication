package com.example.myreca.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myreca.R;
import com.example.myreca.adapter.ChuongTrinhHocAdapter;
import com.example.myreca.helper.ChuongTrinhHocDBHelper;
import com.example.myreca.model.ChuongTrinhHoc;

import java.util.ArrayList;
import java.util.List;

public class ChuongTrinhHocActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ChuongTrinhHoc> chuongTrinhHocList;
    private ChuongTrinhHocAdapter adapter;
    private ChuongTrinhHocDBHelper trinhHocDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong_trinh_hoc);


        recyclerView = (RecyclerView) findViewById(R.id.chuongtrinhhoc_recycler_view);
        chuongTrinhHocList = new ArrayList<>();
        adapter = new ChuongTrinhHocAdapter(this, chuongTrinhHocList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

//        prepareChuongTrinhHoc();
        showData();
    }

    private  void prepareChuongTrinhHoc(){
        ChuongTrinhHoc cth = new ChuongTrinhHoc(0, "第１か");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(1, "第二課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(2, "第３課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(3, "第４課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(4, "第５課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(5, "第６課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(6, "第７課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(7, "第８課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(8, "第９課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(9, "第１０課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(10, "第１２課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(11, "第１３課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１４課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１５課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１６課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１７課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１８課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１９課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２０課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２１課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２２課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２３課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２４課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２５課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２６課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２７課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第２８課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１４課");
        chuongTrinhHocList.add(cth);

        cth = new ChuongTrinhHoc(0, "第１４課");
        chuongTrinhHocList.add(cth);

        adapter.notifyDataSetChanged();
    }

    private void showData() {
        List<ChuongTrinhHoc> result = null;
        trinhHocDBHelper = new ChuongTrinhHocDBHelper(this);

        result = trinhHocDBHelper.getAllChuongTrinhHoc();
        if (result.size() > 0) {
            for (ChuongTrinhHoc item: result) {
                chuongTrinhHocList.add(item);
            }
        }

        adapter.notifyDataSetChanged();
    }
}
