package com.qiankun.recycler.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by xcy on 2017/7/24.
 * 嵌套滑动控件时 解决滑动冲突问题  根本原因待探究 TODO
 */

public class MyScroll extends ScrollView {
    public MyScroll(Context context) {
        super(context);
    }

    public MyScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
