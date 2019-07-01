package com.kingyzll.startanimationandtoinitialposition;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout item1, item2;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item1 = findViewById(R.id.imageview1);
        item2 = findViewById(R.id.imageview2);
        height = getViewHeight(item1,true);
        findViewById(R.id.doit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item1.setTranslationY(height - 50);
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, height);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int h = (int) animation.getAnimatedValue();
                        item2.setTranslationY(-h);
                    }
                });
                valueAnimator.setDuration(1000);
                valueAnimator.start();

                ValueAnimator valueAnimator1 = ValueAnimator.ofInt(height - 50, 0);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();
                        item1.setTranslationY(value);
                    }
                });
                valueAnimator1.setDuration(2000);
                valueAnimator1.start();
            }
        });

        findViewById(R.id.doitagin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item1.setTranslationY(-height);
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, height - 50);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int h = (int) animation.getAnimatedValue();
                        item2.setTranslationY(h);
                    }
                });
                valueAnimator.setDuration(1000);
                valueAnimator.start();

                ValueAnimator valueAnimator1 = ValueAnimator.ofInt(-height, 0);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int h = (int) animation.getAnimatedValue();
                        item1.setTranslationY(h);
                    }
                });
                valueAnimator1.setDuration(1000);
                valueAnimator1.start();
            }
        });


    }

    /**
     * 通过boolean属性直接获取高或宽
     *
     * @param view
     * @param isHeight
     * @return
     */
    public static int getViewHeight(View view, boolean isHeight) {
        int result;
        if (view == null) return 0;
        if (isHeight) {
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            view.measure(h, 0);
            result = view.getMeasuredHeight();
        } else {
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            view.measure(0, w);
            result = view.getMeasuredWidth();
        }
        return result;
    }

}
