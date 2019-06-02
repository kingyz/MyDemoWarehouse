package com.kingyzll.tablayoutdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingyzll.tablayoutdemo.Adapter.SubAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentMainPage1  extends Fragment {

    private List<Fragment> fragments;
    private String[] titles = {"kingyz","ll"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    private SubAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_page1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = view.findViewById(R.id.sub_tab_layout);
        viewPager = view.findViewById(R.id.sub_view_page);

        fragments = new ArrayList<>();
        fragments.add(new FragmentSubPage1());
        fragments.add(new FragmentSubPage2());

        adapter = new SubAdapter(getChildFragmentManager(),fragments,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
