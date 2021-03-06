package com.qiankun.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiankun.recycler.R;
import com.qiankun.recycler.bean.DataUser;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<DataUser> mUsers;
    private List<DataUser> mSystems;


    private static final int ITEM_VIEW_TYPE_TITLE = 0;

    private static final int ITEM_VIEW_TYPE_ITEM = 1;


    public TestAdapter(Context context, List<DataUser> users, List<DataUser> systems) {
        mContext = context;
        mUsers = users;
        mSystems = systems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            view.setOnClickListener(this);
            return new TextViewHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title, parent, false);
        return new TitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (0 <= position && position < mUsers.size()) {
            if (holder instanceof TextViewHolder) {
                ((TextViewHolder) holder).tv.setText(mUsers.get(position).getName());
                ((TextViewHolder) holder).itemView.setTag(position);
                if (mUsers.get(position).getClick() ==false){
                  ((TextViewHolder) holder).tv.setBackgroundResource((R.drawable.select_shape_normal));
                }else {
                    ((TextViewHolder) holder).tv.setBackgroundResource((R.drawable.select_shape_select));
                }
            }
        } else if (position == mUsers.size()) {
            if (holder instanceof TitalViewHolder) {
                ((TitalViewHolder) holder).mTextView.setText("指标");
            }
        } else if (position > mUsers.size()) {
            if (holder instanceof TextViewHolder) {
                ((TextViewHolder) holder).tv.setText(mSystems.get(position - mUsers.size() - 1).getName());
                ((TextViewHolder) holder).itemView.setTag(position);
                if (mSystems.get(position-mUsers.size()-1).getClick()==false){
                    ((TextViewHolder) holder).tv.setBackgroundResource((R.drawable.select_shape_normal));
                }else {
                    ((TextViewHolder) holder).tv.setBackgroundResource((R.drawable.select_shape_select));
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return mUsers.size() + mSystems.size() + 1;
    }

    public boolean isTitle(int position) {
        return position == mUsers.size();
    }

    @Override
    public int getItemViewType(int position) {

        return isTitle(position) ? ITEM_VIEW_TYPE_TITLE : ITEM_VIEW_TYPE_ITEM;
    }


    static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public TextViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    static class TitalViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public TitalViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textview);
        }
    }


    private OnItemClickListener mOnItemClickListener = null;

    //define interface 第一步 定义接口
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {

        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (Integer) v.getTag());
            if (0 <= (Integer) v.getTag() && (Integer) v.getTag() < mUsers.size()){
                if (mUsers.get((Integer) v.getTag()).getClick()==false){
                    mUsers.get((Integer) v.getTag()).setClick(true);
                }else {
                  mUsers.get((Integer) v.getTag()).setClick(false);
                }
            }else if ((Integer) v.getTag() > mUsers.size()){
                if (mSystems.get((Integer) v.getTag() -mUsers.size()-1).getClick()==false) {
                    mSystems.get((Integer) v.getTag()-mUsers.size()-1).setClick(true);
                }else {
                    mSystems.get((Integer) v.getTag()-mUsers.size()-1).setClick(false);
                }
            }
            notifyDataSetChanged();
        }
    }
}
