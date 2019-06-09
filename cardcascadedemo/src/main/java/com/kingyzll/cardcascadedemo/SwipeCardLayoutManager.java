package com.kingyzll.cardcascadedemo;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class SwipeCardLayoutManager extends RecyclerView.LayoutManager {
    private int verticalScrollOffset;

    private Context context;
    private int totalHeight;
    /**
     * 用于保存item的位置信息
     */
    private SparseArray<Rect> allItemRects = new SparseArray<>();
    /**
     * 用于保存item是否处于可见状态的信息
     */
    private SparseBooleanArray itemStates = new SparseBooleanArray();

    int TRANS_Y_GAP;

    SwipeCardLayoutManager(Context context) {
        this.context = context;
        TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80,
                context.getResources().getDisplayMetrics());
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        detachAndScrapAttachedViews(recycler);

        calculateChildrenSite(recycler);


    }

    private void calculateChildrenSite(RecyclerView.Recycler recycler) {
        totalHeight = 0;

        int parentHeight = getHeight();

        for (int i = 0; i < getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view, 0, 0);
            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            totalHeight = height + TRANS_Y_GAP * (getItemCount() - 1);
            if (totalHeight >= parentHeight) {
                layoutDecorated(view,
                        widthSpace / 2,
                        TRANS_Y_GAP * i,
                        widthSpace / 2 + getDecoratedMeasuredWidth(view),
                        getDecoratedMeasuredHeight(view) + TRANS_Y_GAP * i);
                Log.e("abc", String.valueOf(parentHeight));
                Log.e("abc", "totalHeight" + String.valueOf(totalHeight));
            } else {
                int transY = parentHeight - totalHeight;

                layoutDecorated(view,
                        widthSpace / 2,
                        TRANS_Y_GAP * i + transY,
                        widthSpace / 2 + getDecoratedMeasuredWidth(view),
                        getDecoratedMeasuredHeight(view) + TRANS_Y_GAP * i + transY);
            }

            //摆放cardView


        }

    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {

        int travel = dy;

        if (verticalScrollOffset + dy < 0 && totalHeight > getHeight()) {
            travel = -verticalScrollOffset;
        } else if (verticalScrollOffset + dy > totalHeight - getVerticalSpace() && totalHeight > getHeight()) {
            travel = totalHeight - getVerticalSpace() - verticalScrollOffset;
        } else if (getHeight() > totalHeight) {
            travel = 0;
        }
        verticalScrollOffset += travel;

        offsetChildrenVertical(-travel);

        return travel;
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }

    //    private void recycleAndFillView(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        if (getItemCount() <= 0 || state.isPreLayout()) {
//            return;
//        }
//
//        // 当前scroll offset状态下的显示区域
//        Rect displayRect= new Rect(0, verticalScrollOffset, getHorizontalSpace(),
//                verticalScrollOffset + getVerticalSpace());
//
//        /**
//         * 将滑出屏幕的Items回收到Recycle缓存中
//         */
//        Rect childRect = new Rect();
//        for (int i = 0; i < getChildCount(); i++) {
//            //这个方法获取的是RecyclerView中的View，注意区别Recycler中的View
//            //这获取的是实际的View
//            View child = getChildAt(i);
//            //下面几个方法能够获取每个View占用的空间的位置信息，包括ItemDecorator
//            childRect.left = getDecoratedLeft(child);
//            childRect.top = getDecoratedTop(child);
//            childRect.right = getDecoratedRight(child);
//            childRect.bottom = getDecoratedBottom(child);
//            //如果Item没有在显示区域，就说明需要回收
//            if (!Rect.intersects(displayRect, childRect)) {
//                //移除并回收掉滑出屏幕的View
//                removeAndRecycleView(child, recycler);
//                itemStates.put(i, false); //更新该View的状态为未依附
//            }
//        }
//
//        //重新显示需要出现在屏幕的子View
//        for (int i = 0; i < getItemCount(); i++) {
//            //判断ItemView的位置和当前显示区域是否重合
//            if (Rect.intersects(displayRect, allItemRects.get(i))) {
//                //获得Recycler中缓存的View
//                View itemView = recycler.getViewForPosition(i);
//                measureChildWithMargins(itemView, DisplayUtils.getScreenWidth() / 2, 0);
//                //添加View到RecyclerView上
//                addView(itemView);
//                //取出先前存好的ItemView的位置矩形
//                Rect rect = allItemRects.get(i);
//                //将这个item布局出来
//                layoutDecoratedWithMargins(itemView,
//                        rect.left,
//                        rect.top - verticalScrollOffset,  //因为现在是复用View，所以想要显示在
//                        rect.right,
//                        rect.bottom - verticalScrollOffset);
//                itemStates.put(i, true); //更新该View的状态为依附
//            }
//        }
//    }
    public int getHorizontalSpace() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

}