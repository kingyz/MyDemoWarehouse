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

import com.kingyzll.tablayoutdemo.Adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] title={"kingyz","ll"};
    private List<Fragment> fragments;
    private MainAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = view.findViewById(R.id.main_tab_layout);
        viewPager = view.findViewById(R.id.main_view_pager);

        fragments = new ArrayList<>();
        fragments.add(new FragmentMainPage1());
        fragments.add(new FragmentMainPage2());

        adapter = new MainAdapter(getChildFragmentManager(),fragments,title);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
