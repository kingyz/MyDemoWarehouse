package com.kingyzll.tablayoutdemo.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class SubAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private String[] titles;

    public SubAdapter(FragmentManager fm,List<Fragment> fragments,String[] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles =titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
