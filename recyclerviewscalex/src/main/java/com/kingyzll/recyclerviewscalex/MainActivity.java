package com.kingyzll.recyclerviewscalex;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Bean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitData();

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        MyAdapter adapter = new MyAdapter(beanList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

//        ValueAnimator animator = ValueAnimator.ofFloat(1,0.7f);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                recyclerView.setScaleX(value);
//                recyclerView.setScaleY(value);
//            }
//        });
//        animator.setDuration(1000);
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());
//        animator.start();

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scalex);
        recyclerView.setAnimation(animation);

    }

    private void intitData() {

        for (int i =0;i<10;i++){
            Bean bean = new Bean(String.valueOf(i));
            beanList.add(bean);
        }

    }


}
