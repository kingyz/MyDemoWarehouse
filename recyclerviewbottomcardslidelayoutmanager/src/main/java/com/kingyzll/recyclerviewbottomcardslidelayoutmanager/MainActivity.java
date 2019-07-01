package com.kingyzll.recyclerviewbottomcardslidelayoutmanager;

import android.graphics.Rect;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClicKListener {

    List<Bean> beanList = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager manager;
    ImageView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(1);
                if (holder != null) {
                    MyAdapter.ViewHolder viewHolder = (MyAdapter.ViewHolder) holder;
                  viewHolder.itemView.setTranslationZ(10f);
                  viewHolder.itemView.setTranslationY(200);


                }
            }
        });


    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            Bean bean1 = new Bean(R.drawable.a);
            beanList.add(bean1);
            Bean bean2 = new Bean(R.drawable.b);
            beanList.add(bean2);
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        MyAdapter adapter = new MyAdapter(beanList);
        adapter.setClicKListener(this);
        manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void doit(int positon) {
        Toast.makeText(this, String.valueOf(positon), Toast.LENGTH_SHORT).show();
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                View view = manager.findViewByPosition(0);	//2为recyclerView中item位置，
//                //mLayoutManager为recyclre的布局管理器
//                LinearLayout layout = (LinearLayout)view;	//获取布局中任意控件对象
//                status = (ImageView) layout.findViewById(R.id.image);  } },300);}



}
