package com.lanou.project.chanyouji;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lanou.project.chanyouji.Fragment.RaidersFragment;

import com.lanou.project.chanyouji.base.LinePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;
    List<String> titleList;

  LinePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          initView();
          initData();
    }



    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.main_content);
        tabLayout = (TabLayout) findViewById(R.id.tab_main);

    }

    private void initData() {

        fragmentList =new ArrayList<>();

        fragmentList.add(new RaidersFragment());
        fragmentList.add(new RaidersFragment());
        fragmentList.add(new RaidersFragment());

        titleList=new ArrayList<>();


        titleList.add("游记");
        titleList.add("攻略");
        titleList.add("工具箱");

        adapter=new LinePagerAdapter(this,getSupportFragmentManager(),titleList,fragmentList);

        tabLayout.setTabTextColors(Color.BLACK,Color.BLACK);
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i=0;i<titleList.size();i++){
            TabLayout.Tab tab=tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getPageView(i));
        }

    }

}
