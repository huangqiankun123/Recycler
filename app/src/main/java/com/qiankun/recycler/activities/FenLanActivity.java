package com.qiankun.recycler.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.qiankun.recycler.MainActivity;
import com.qiankun.recycler.R;
import com.qiankun.recycler.adapter.SingleAdapter;
import com.qiankun.recycler.bean.DataUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xcy on 2017/7/30.
 * scrollview 嵌套 recylcerview  实现单选 多选
 */

public class FenLanActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<DataUser> mUsers;
    private List<DataUser> mSystems;
    private List<String> resoure = new ArrayList<>();
    private int userSelect = -1;
    private int systemSelect = -1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlan);


        initData();
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == mUsers.size()) {
                    return 3;
                }
                return 1;
            }
        });
        mRecyclerView.setLayoutManager(manager);
//        TestAdapter adapter = new TestAdapter(this, mUsers, mSystems);
        final SingleAdapter adapter = new SingleAdapter(this, mUsers, mSystems);
        mRecyclerView.setAdapter(adapter);


//        adapter.setOnItemClickListener(new TestAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                if (0 <= position && position < mUsers.size()) {
//                    Toast.makeText(MainActivity.this, mUsers.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
//                    if (!resoure.contains(mUsers.get(position).getName())) {
//                        resoure.add(mUsers.get(position).getName());
//                    } else {
//                        resoure.remove(mUsers.get(position).getName());
//                    }
//                } else if (position == mUsers.size()) {
//
//                } else if (position > mUsers.size()) {
//                    if (!resoure.contains(mSystems.get(position - mUsers.size() - 1).getName())) {
//                        resoure.add(mSystems.get(position - mUsers.size() - 1).getName());
//
//                    } else {
//                        resoure.remove(mSystems.get(position - mUsers.size() - 1).getName());
//                    }
//
//                    Toast.makeText(MainActivity.this, mSystems.get(position - mUsers.size() - 1).getName().toString(), Toast.LENGTH_SHORT).show();
//                }
//                Log.i("nihao", resoure.toString());
//            }
//        });

        adapter.setOnItemClickListener(new SingleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (0 <= position && position < mUsers.size()) {
                    adapter.changeState1(position);
                    userSelect=position;
                    Toast.makeText(FenLanActivity.this, mUsers.get(userSelect).getName().toString(), Toast.LENGTH_SHORT).show();

                } else if (position == mUsers.size()) {

                } else if (position > mUsers.size()) {
                    adapter.changeState2(position);
                    systemSelect =position;

                    Toast.makeText(FenLanActivity.this, mSystems.get(systemSelect - mUsers.size() - 1).getName().toString(), Toast.LENGTH_SHORT).show();
                }
                Log.i("nihao", resoure.toString());
            }
        });

    }

    private void initData() {

        mUsers = new ArrayList<>();
        DataUser data1 = new DataUser("张三", false);
        mUsers.add(data1);
        DataUser data2 = new DataUser("李四", false);
        mUsers.add(data2);
        DataUser data3 = new DataUser("王五", false);
        mUsers.add(data3);
        DataUser data4 = new DataUser("赵六", false);
        mUsers.add(data4);
        DataUser data5 = new DataUser("张日天", false);
        mUsers.add(data5);
        DataUser data6 = new DataUser("叶辰良", false);
        mUsers.add(data6);
        DataUser data7 = new DataUser("叶辰良", false);
        mUsers.add(data7);
        DataUser data8 = new DataUser("叶辰良", false);
        mUsers.add(data8);
        DataUser data9 = new DataUser("叶辰良", false);
        mUsers.add(data9);
        DataUser data10 = new DataUser("叶辰良", false);
        mUsers.add(data10);
        DataUser data11 = new DataUser("叶辰良", false);
        mUsers.add(data11);
        DataUser data12 = new DataUser("叶辰良", false);
        mUsers.add(data12);
        DataUser data13 = new DataUser("叶辰良", false);
        mUsers.add(data13);

        mSystems = new ArrayList<>();
        DataUser system1 = new DataUser("C盘", false);
        mSystems.add(system1);
        DataUser system2 = new DataUser("D盘", false);
        mSystems.add(system2);
        DataUser system3 = new DataUser("E盘", false);
        mSystems.add(system3);
        DataUser system4 = new DataUser("F盘", false);
        mSystems.add(system4);
        DataUser system5 = new DataUser("G盘", false);
        mSystems.add(system5);
        DataUser system6 = new DataUser("H盘", false);
        mSystems.add(system6);
        DataUser system7 = new DataUser("I盘", false);
        mSystems.add(system7);
        DataUser system8 = new DataUser("G盘", false);
        mSystems.add(system8);
        DataUser system9 = new DataUser("K盘", false);
        mSystems.add(system9);
        DataUser system10 = new DataUser("M盘", false);
        mSystems.add(system10);


    }
}
