package com.lanou.project.chanyouji.ToolActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.Fragment.City2Fragment;
import com.lanou.project.chanyouji.Fragment.CityFragment;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.base.LinePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity implements View.OnClickListener{


    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;
    List<String> titleList;

    LinePagerAdapter adapter;

   ImageView imageView1,imageView2;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        initView();
        initEvent();
        initData();
    }

    private void initEvent() {
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        textView.setOnClickListener(this);

    }



    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.city_View);
        tabLayout= (TabLayout) findViewById(R.id.city_table);
        imageView1= (ImageView) findViewById(R.id.back_image);
        imageView2= (ImageView) findViewById(R.id.chan_image);
        textView= (TextView) findViewById(R.id.title_text);
    }
    private void initData() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new CityFragment());
        fragmentList.add(new City2Fragment());
        titleList = new ArrayList<>();


        titleList.add("国外");
        titleList.add("国内");
        adapter = new LinePagerAdapter(this, getSupportFragmentManager(), titleList, fragmentList);


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(6);

        for (int i = 0; i < titleList.size(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getPageView(i));

        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_image:
            case R.id.chan_image:
            case R.id.title_text:
                finish();
                break;
        }
    }
}
