package com.kingyzll.addlist;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemPadding  extends RecyclerView.ItemDecoration {

    private int dis;

    public ItemPadding(int dis){
        this.dis = dis;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = dis;
    }
}
