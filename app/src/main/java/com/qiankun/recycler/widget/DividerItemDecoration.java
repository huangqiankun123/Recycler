package com.qiankun.recycler.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xcy on 2017/7/29.
 * 条目的分割线  （单纯的分割线）
 * 先调用 getItemOffsets方法获取偏移量
 * 再调用 onDraw 绘制
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mOrientation = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    private int[] attrs = new int[]{android.R.attr.listDivider};

    public DividerItemDecoration(Context context, int mOrientation) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(mOrientation);
    }

    /**
     * 暴露给外面 选择分割先的方向
     *
     * @param orientation
     */
    public void setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("哥们,逗我玩吗？非水平和线性的枚举");
        }
        this.mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //Reyclerview 回掉该绘制方法 ，需要自己去绘制分割线
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            //传入 画板  和 recycler view
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
        super.onDraw(c, parent, state);
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        /**
         * 此时 之考虑内边距   外边距有recycler自身决定
         * parent.getWidth() 包括了getPaddingLeft(); 和 parent.getPaddingRight();
         */
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        //因为是绘制所有的item 所以要循环的绘制
        int childCount = parent.getChildCount(); //获取到所有子view的个数
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i); //获取到任意的vied
            //childAt.getBottom() :Bottom position of this view relative to its parent 条目的最下边离父容器的距离
            // 默认第一条不画的
            //获取childAt 的属性  获取外边距 （内边距是相对自己来说的  ）
            //
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            //params.bottomMargin 获取到外边距
            //ViewCompat.getTranslationY(childAt) 动画的偏移量
            //Math.round 四舍五入 转换成int
            int top = childAt.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(childAt));

            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = childAt.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(childAt));
            int right = left + mDivider.getIntrinsicWidth();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }

    /**
     * @param outRect Rect 条目之间的间隙宽度 本身是一个矩形区域
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //获取条目的偏移量（所有的条目都回掉用一次该方法） 自定义写的 干掉super
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            //set 方法中参数 左上右下 顺序 getIntrinsicHeight
            /**
             * mDivider.getIntrinsicHeight() 获取draw able 的绝对高度
             */
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
