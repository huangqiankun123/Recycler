package com.qiankun.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qiankun.recycler.activities.DialogActivity;
import com.qiankun.recycler.activities.DividerActivity;
import com.qiankun.recycler.activities.FenLanActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, FenLanActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, DividerActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, DialogActivity.class));
                break;
        }
    }
}
