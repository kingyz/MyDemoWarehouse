package com.kingyzll.cardcascadedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UniversalAdapter extends RecyclerView.Adapter<UniversalAdapter.UniversalViewHolder> {

    PositionListener positionListener1;

    public ArrayList<SwipeCardBean> mData;
    public Context context;

    public UniversalAdapter(ArrayList<SwipeCardBean> mData, Context context) {
        this.mData = mData;
        this.context = context;

    }

    public void setPositionListener1(PositionListener positionListener1) {
        this.positionListener1 = positionListener1;
    }

    @NonNull
    @Override
    public UniversalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, viewGroup, false);
        UniversalViewHolder holder = new UniversalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UniversalViewHolder universalViewHolder, final int i) {
        final int position = i;
        SwipeCardBean swipeCardBean = mData.get(i);
        universalViewHolder.recy_item_tv.setText(swipeCardBean.title);
        universalViewHolder.recy_item_im.setBackgroundResource(swipeCardBean.resoutimage);

        universalViewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "item is :" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                //holder1.container.fin
                positionListener1.doit(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public class UniversalViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout, container;

        public TextView recy_item_tv;
        public ImageView recy_item_im;

        public UniversalViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            linearLayout = (LinearLayout) itemView;
            recy_item_im = itemView.findViewById(R.id.recy_item_im);
            recy_item_tv = itemView.findViewById(R.id.recy_item_tv);
        }
    }

}
