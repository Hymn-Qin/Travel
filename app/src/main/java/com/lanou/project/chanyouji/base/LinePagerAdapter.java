package com.lanou.project.chanyouji.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;

import java.util.List;

/**
 * Created by lanouhn on 16/8/17.
 */
public class LinePagerAdapter extends FragmentPagerAdapter {

    TextView textView;

    List<Fragment> fragmentList;
    List<String> stringList;
    Context context;

    public LinePagerAdapter(Context context, FragmentManager fm,  List<String >stringList, List<Fragment> fragmentList){
        super(fm);

        this.context=context;
        this.fragmentList=fragmentList;
        this.stringList=stringList;

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList!=null?fragmentList.size():0;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    /**
     *  获取TabLayout每个对应的视图布局
     * @param position
     * @return
     */

    public View getPageView(int position){

        View view= LayoutInflater.from(context).inflate(R.layout.tab_layout,null);
        textView= (TextView) view.findViewById(R.id.text1);

        textView.setText(stringList.get(position));

        return view;

    }
}
