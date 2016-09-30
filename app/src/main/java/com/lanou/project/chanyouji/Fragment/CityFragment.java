package com.lanou.project.chanyouji.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.City;
import com.lanou.project.chanyouji.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lanouhn on 16/9/18.
 */
public class CityFragment extends Fragment {


    List<City.DestinationsBean> destinationsList = new ArrayList<>();
    Handler handler;
    ExpandableAdapter exAdapter;
    ExpandableListView expandableListView;
    List<City> cityList;
    View view;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.city_l, container, false);
        expandableListView= (ExpandableListView) view.findViewById(R.id.listView);

        initEvent();
        expandableListView.setGroupIndicator(null);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200) {
                     exAdapter= new ExpandableAdapter(getContext(), destinationsList);
                   expandableListView.setAdapter(exAdapter);
                }
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

               Intent intent =new Intent();
                int li =destinationsList.get(groupPosition).getChildren().get(childPosition).getId();
                String lli=destinationsList.get(groupPosition).getChildren().get(childPosition).getName_zh_cn();
                  intent.putExtra("id",li);
                  intent.putExtra("name",lli);
                getActivity().setResult(201,intent);
                getActivity().finish();
                return false;
            }
        });
        return view;
    }
    private void initEvent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn("http://chanyouji.com/api/wiki/destinations.json",
                        new HttpUtils.CallBack() {
                            @Override
                            public void onRequestComplete(String result) {
                                Gson gson = new Gson();
                                cityList = gson.fromJson(result,
                                        new TypeToken<List<City>>() {
                                        }.getType());
                                for (City city : cityList) {
                                    if (city.getCategory().equals("1") || city.getCategory().equals("2") || city.getCategory().equals("3")) {
                                        destinationsList.addAll(city.getDestinations());
                                    }
                                }
                                handler.sendEmptyMessage(200);
                            }
                        });
            }
        }).start();
    }
    class  ExpandableAdapter extends BaseExpandableListAdapter {

        List<City.DestinationsBean> destinationsList;

        Context context;
        public ExpandableAdapter(Context context,  List<City.DestinationsBean> destinationsList) {


            this.context=context;
            this.destinationsList=destinationsList;

        }

        @Override
        public int getGroupCount() {
            return destinationsList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return destinationsList.get(groupPosition).getChildren().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return destinationsList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return destinationsList.get(groupPosition).getChildren().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

             if (convertView==null){
                 LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 convertView=inflater.inflate(R.layout.city_item_layout,null);
             }
            TextView tv= (TextView) convertView.findViewById(R.id.city_text);

            tv.setText(destinationsList.get(groupPosition).getName_zh_cn());
            return tv;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


            if (convertView==null){
                LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView=inflater.inflate(R.layout.city_item2,null);
            }
            TextView tv= (TextView) convertView.findViewById(R.id.city_item_text);
            tv.setText(destinationsList.get(groupPosition).getChildren().get(childPosition).getName_zh_cn());
            return tv;
        }
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }



}
