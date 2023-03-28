package com.hsf.fixed.item_decoration_two;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hsf.fixed.R;

//如果侄子
public class MyItemDecorationTwo extends RecyclerView.ItemDecoration{
    private final Drawable mDivider;

    public MyItemDecorationTwo(Context context) {
        mDivider = context.getResources().getDrawable(R.drawable.divider);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawVertical(c, parent);
        drawHorizontal(c, parent);
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {

        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isLastColumn(i, recyclerView)) {
                continue;
            }

            View child = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int top = child.getTop() - params.topMargin;
            int right = left + mDivider.getIntrinsicWidth();
            //这里加上 mDivider.getIntrinsicHeight()，可以把中间空白的部分补上
            int bottom = child.getBottom() + params.bottomMargin;
//                    + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }

    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isLastRow(i, recyclerView)) {
                continue;
            }

            View child = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getLeft() - params.leftMargin;
            int top = child.getBottom() + params.bottomMargin;
            int right = child.getRight() + params.rightMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();

        if (isLastColumn(position, parent)) {
            right = 0;
        }

        Log.d("Daisy", "当前是：" + position + " / " + isLastRow(position, parent));
        if (isLastRow(position, parent)) {
            bottom = 0;
        }

        outRect.set(0, 0, right, bottom);

        Log.d("Daisy", "查看位置:" + ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition());
        Log.d("Daisy", "查看位置2：" + parent.indexOfChild(view));
    }

    private boolean isLastColumn(int itemPosition, RecyclerView rv) {
        RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            if ((itemPosition + 1) % spanCount == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isLastRow(int itemPosition, RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();  //列数

            int rowCount = itemPosition / spanCount;  //行数
            Log.d("Daisy", "判断是不是最后一行" + rowCount + " / " + spanCount + " / " + ((itemPosition + 1) > rowCount * spanCount));
            if ((itemPosition + 1) > rowCount * spanCount) {
                return true;
            }
        }
        return false;
    }
}
