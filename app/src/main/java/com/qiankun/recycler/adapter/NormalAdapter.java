package com.qiankun.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiankun.recycler.R;

import java.util.List;

/**
 * Created by xcy on 2017/7/30.
 */

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> stringList;

    public NormalAdapter(Context mContext, List<String> stringList) {
        this.mContext = mContext;
        this.stringList = stringList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_normal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
