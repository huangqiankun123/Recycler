package com.qiankun.recycler.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.qiankun.recycler.R;

/**
 * Created by xcy on 2017/8/14.
 */

public class CommonDialog extends Dialog {

    public CommonDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_item);
        setCanceledOnTouchOutside(true);
        initView();
    }

    private void initView() {

    }
}
