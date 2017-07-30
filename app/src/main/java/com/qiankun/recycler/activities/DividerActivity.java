package com.qiankun.recycler.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qiankun.recycler.R;
import com.qiankun.recycler.adapter.NormalAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xcy on 2017/7/30.
 */

public class DividerActivity extends AppCompatActivity {

    private List<String> stringList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divider);
        initData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NormalAdapter adapter = new NormalAdapter(this, stringList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    private void initData() {
        stringList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            stringList.add("item" + i);
        }
    }
}
