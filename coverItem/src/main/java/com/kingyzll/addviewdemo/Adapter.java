package com.kingyzll.addviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContent;
    private List<Bean> list;

    public Adapter(List<Bean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContent == null) {
            mContent = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContent).inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Bean bean = list.get(i);
        viewHolder.title.setText(bean.getTilte());
        viewHolder.content.setText(bean.getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        TextView title, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container = (LinearLayout) itemView;
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
        }
    }
}
