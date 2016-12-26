package com.example.myreca.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myreca.R;
import com.example.myreca.model.Album;
import com.example.myreca.model.TuVung;

import java.util.List;



/**
 * Created by linhnd on 2016/12/26.
 */

public class TuVungAdapter extends RecyclerView.Adapter<TuVungAdapter.TuVungViewHolder> {
    private Context mContext;
    private List<TuVung> tuVungList;



    public class TuVungViewHolder extends RecyclerView.ViewHolder {
        public TextView tuvung_kanji;
        public TextView tuvung_vidu;

        public TuVungViewHolder(View view) {
            super(view);
            tuvung_kanji = (TextView) view.findViewById(R.id.txt_tuvung_kanji);
            tuvung_vidu = (TextView) view.findViewById(R.id.txt_tuvung_vidu);
        }
    }

    public TuVungAdapter(Context mContext, List<TuVung> albumList) {
        this.mContext = mContext;
        this.tuVungList = albumList;
    }

    @Override
    public TuVungViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tuvung_card, parent, false);

        return new TuVungViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TuVungViewHolder holder, int position) {
        TuVung tuVung = tuVungList.get(position);

        holder.tuvung_kanji.setText(tuVung.getTuvung_kanji());
        holder.tuvung_vidu.setText(tuVung.getTuvung_vidu());

    }

    @Override
    public int getItemCount() {
        return tuVungList.size();
    }
}
