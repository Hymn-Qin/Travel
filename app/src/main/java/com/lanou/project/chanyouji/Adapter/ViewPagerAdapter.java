package com.lanou.project.chanyouji.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lanouhn on 16/9/27.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    List<String> stringList;
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> stringList) {
        super(fm);
        this.fragmentList=fragmentList;
        this.stringList=stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
