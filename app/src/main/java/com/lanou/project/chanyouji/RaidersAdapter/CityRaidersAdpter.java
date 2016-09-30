package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityRaiders;

import java.util.List;

/**
 * Created by lanouhn on 16/9/19.
 */
public class CityRaidersAdpter extends BaseAdapter {
    Context context;
    List<CityRaiders.PagesBean> pagesBeanList;

    public CityRaidersAdpter(Context context, List<CityRaiders.PagesBean> pagesBeanList){
        this.context = context;
        this.pagesBeanList = pagesBeanList;
    }



    @Override
    public int getCount() {
        return pagesBeanList != null ? pagesBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return pagesBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityRaiderView cityRaiderView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.city_raiders_item, null);
            cityRaiderView = new CityRaiderView();
            cityRaiderView.textView = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(cityRaiderView);
        }else {
            cityRaiderView = (CityRaiderView) convertView.getTag();
        }

        CityRaiders.PagesBean pagesBean = pagesBeanList.get(position);
        cityRaiderView.textView.setText(pagesBean.getTitle());



        return convertView;
    }


    class CityRaiderView {
        TextView textView;
    }
}
