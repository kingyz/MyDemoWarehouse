package com.kingyzll.addlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int position;
    int number = 3;
    int itemHeight;

    List<Bean> list1 = new ArrayList<>();
    List<Bean> list2 = new ArrayList<>();
    List<Bean> list3 = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private MyCustomLayoutManager manager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        position = 4;

        initList();
        initRecyclerView();

        final Bean bean = new Bean("Text");
        list2.add(bean);

        LogPrint();


        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAdapter.ViewHolder viewHolder = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(0);
                if (viewHolder != null) {
                    itemHeight = viewHolder.itemView.getHeight();
                    Log.e("abc", "itemHeight" + itemHeight);
                }
                // list3.subList()
                if (position > 0) {
                    if (position < number) {
                        list3 = list1.subList(0, position);
                        number = position;
                        position = 0;
                    } else {
                        list3 = list1.subList(position - number, position);
                        position -= number;
                    }

                    list2.addAll(0, list3);
                    list3.clear();
                    adapter.notifyDataSetChanged();
                    LogPrint();

                    Log.e("abc", "itemHeight" + itemHeight);
                    // mRecyclerView.smoothScrollBy(0, (itemHeight+30) * number,new DecelerateInterpolator());
                    mRecyclerView.smoothScrollBy(0, (itemHeight + 30) * number,new DecelerateInterpolator(1));

                }


            }
        });

        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list2.subList(list2.size() - 1, list2.size()).clear();
                adapter.notifyDataSetChanged();
                LogPrint();
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bean bean1 = list2.get(list2.size() - 1);
                bean1.setText("UPDATE");
                adapter.notifyDataSetChanged();
                LogPrint();
            }
        });

        findViewById(R.id.scroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.smoothScrollToPosition(number);
            }
        });


    }

    private void LogPrint() {
        Log.e("abc", "" + list2.size());
        Log.e("abc", "list size " + list1.size());


        for (Bean bean1 : list1) {
            Log.e("abc", "list1 :" + bean1.getText());
        }

        for (Bean bean2 : list2) {
            Log.e("abc", "list2 :" + bean2.getText());
        }
    }

    private void initRecyclerView() {

        list3 = list1.subList(4, 6);
        list2.addAll(list3);
        list3.clear();

        mRecyclerView = findViewById(R.id.recyclerview);

        manager = new MyCustomLayoutManager(this);
        adapter = new MyAdapter(list2);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(manager);

        mRecyclerView.addItemDecoration(new ItemPadding(30));

    }

    private void initList() {
        for (int i = 0; i < 2; i++) {
            Bean bean1 = new Bean("K");
            list1.add(bean1);
            Bean bean2 = new Bean("I");
            list1.add(bean2);
            Bean bean3 = new Bean("N");
            list1.add(bean3);
            Bean bean4 = new Bean("G");
            list1.add(bean4);
            Bean bean5 = new Bean("Y");
            list1.add(bean5);
            Bean bean6 = new Bean("Z");
            list1.add(bean6);
        }


        // list1.addAll(0,list2);


    }
}
