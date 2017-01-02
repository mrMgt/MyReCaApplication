package com.example.myreca.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myreca.R;
import com.example.myreca.activity.TuVungActivity;
import com.example.myreca.model.ChuongTrinhHoc;

import java.util.List;

/**
 * Created by mr on 12/31/2016.
 */

public class ChuongTrinhHocAdapter  extends RecyclerView.Adapter<ChuongTrinhHocAdapter.ChuongTrinhHocViewHolder> {

    private Context mContext;
    private List<ChuongTrinhHoc> chuongTrinhHocs;



    public class ChuongTrinhHocViewHolder extends RecyclerView.ViewHolder {
        public TextView baihocso;
        public TextView debai;
        public TextView noidung;
        public View view;

        public ChuongTrinhHocViewHolder(View v) {
            super(v);
            view = v;
            baihocso = (TextView) view.findViewById(R.id.txtBaiso);
//            debai = (TextView) view.findViewById(R.id.txtDebai);
//            noidung = (TextView) view.findViewById(R.id.txtContent);
            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoTuVung(view);
                }
            });*/
        }
    }

    public ChuongTrinhHocAdapter(Context mContext, List<ChuongTrinhHoc> chuongTrinhHocs) {
        this.mContext = mContext;
        this.chuongTrinhHocs = chuongTrinhHocs;
    }

    @Override
    public ChuongTrinhHocViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.baihoc_card, parent, false);

        return new ChuongTrinhHocAdapter.ChuongTrinhHocViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ChuongTrinhHocViewHolder holder,final int position) {
        ChuongTrinhHoc chuongTrinhHoc = chuongTrinhHocs.get(position);

        holder.baihocso.setText(chuongTrinhHoc.getBaihocso());
//        holder.debai.setText(chuongTrinhHoc.getDebaihoc());
//        holder.noidung.setText(chuongTrinhHoc.getNoidungkhaiquat());
        holder.baihocso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoTuVung(view, position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return chuongTrinhHocs.size();
    }

    public void gotoTuVung(View view, int position) {
        Intent intent = new Intent(mContext, TuVungActivity.class);
        intent.putExtra("lessonid",chuongTrinhHocs.get(position).getId()+"");
        mContext.startActivity(intent);
    }
}
