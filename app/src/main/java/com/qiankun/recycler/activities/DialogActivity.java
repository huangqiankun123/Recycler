package com.qiankun.recycler.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.qiankun.recycler.R;
import com.qiankun.recycler.widget.CommonDialog;

/**
 * Created by xcy on 2017/8/14.
 */

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailog);
        Button dialog_btn = (Button) findViewById(R.id.dialog);
        dialog_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog:
                CommonDialog commonDialog = new CommonDialog(this);
                commonDialog.show();
                // //设置dialog的大小和坐标，一直要放到show()方法的后面
                Window dialogWindow = commonDialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.BOTTOM);
                //设置dialog的大小填充整个屏幕
//                lp.width= WindowManager.LayoutParams.MATCH_PARENT;
//                lp.height= WindowManager.LayoutParams.MATCH_PARENT;
                //也可以根据屏幕大小来这只dialog的大小，比如屏幕的1/6
                WindowManager windowManager = dialogWindow.getWindowManager();
                Display d = windowManager.getDefaultDisplay(); // 获取屏幕宽、高用
                lp.height = (int) (d.getHeight() * 0.25); // 高度设置为屏幕
                lp.width = (int) (d.getWidth() * 0.95); // 宽度设置为屏幕的

        /*lp.x = 100; // 新位置X坐标
        lp.y = 100; // 新位置Y坐标*/
                dialogWindow.setAttributes(lp);
                break;
        }
    }
}
