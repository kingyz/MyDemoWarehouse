package com.kingyzll.addviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        Adapter adapter = new Adapter(list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for(int i=0;i<5;i++){
            Bean bean = new Bean("Kingyz","loveLL");
            list.add(bean);
        }
    }
}
