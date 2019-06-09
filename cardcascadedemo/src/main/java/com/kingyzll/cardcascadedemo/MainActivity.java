package com.kingyzll.cardcascadedemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PositionListener {

    private RecyclerView mActivity_review;
    private UniversalAdapter mAdapter;
    private ArrayList<SwipeCardBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setData();
    }


    private void initData() {
        int[] initimage = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g, R.drawable.a};
        for (int i = 0; i < 3; i++) {
            SwipeCardBean swipeCardBean = new SwipeCardBean();
            swipeCardBean.resoutimage = initimage[i];
            swipeCardBean.title = "美丽" + i;
            mList.add(swipeCardBean);
        }
    }

    private void initView() {
        mList = new ArrayList<>();
        mActivity_review = findViewById(R.id.activity_review);
    }

    SwipeCardLayoutManager layoutManager;

    private void setData() {
        layoutManager = new SwipeCardLayoutManager(this);
        mActivity_review.setLayoutManager(layoutManager);
        mAdapter = new UniversalAdapter(mList, this);
        mAdapter.setPositionListener1(this);
        mActivity_review.setAdapter(mAdapter);
        CardConfig.initConfig(this);

        //int height = mActivity_review.computeVerticalScrollRange();
       // Log.e("abc", String.valueOf(height));

        

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                View view = layoutManager.findViewByPosition(3);
//                LinearLayout linearLayout = (LinearLayout) view;
////                ImageView imageView = linearLayout.findViewById(R.id.recy_item_im);
////                imageView.setBackgroundResource(R.drawable.ic_launcher_background);
//                linearLayout.setTranslationY(60);
//            }
//        }, 500);
    }


    @Override
    public void doit(int position) {
        for (int i = position + 1; i < mList.size(); i++) {
            View view = layoutManager.findViewByPosition(i);
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout != null) {

                linearLayout.setTranslationY(60);
            } else {
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
