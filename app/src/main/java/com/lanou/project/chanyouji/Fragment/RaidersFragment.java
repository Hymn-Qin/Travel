package com.lanou.project.chanyouji.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.Interface.OnViewItemClickListener;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.Country;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.Raiders.NoScrollGridView;
import com.lanou.project.chanyouji.RaidersActivity.CountryBriefActivity;
import com.lanou.project.chanyouji.RaidersAdapter.CountryAdapter;
import com.lanou.project.chanyouji.RaidersAdapter.ScanAdapter;
import com.lanou.project.chanyouji.utils.HttpUtils;



import java.util.ArrayList;

import java.util.List;

/**
 * Created by lanouhn on 16/9/13.
 */
public class RaidersFragment extends Fragment {

    String raidersUrl = "http://chanyouji.com/api/destinations.json?page=1";
    View view;
    NoScrollGridView scan, asia, europe, america, hkt, china;
    List<String> addressList = new ArrayList<>();
    ScanAdapter scanAdapter;
    CountryAdapter adapter;
    List<Country> countryList;
    List<Country.DestinationsBean> scanList;
    List<Country.DestinationsBean> asiaList = new ArrayList<>();
    List<Country.DestinationsBean> europeList = new ArrayList<>();
    List<Country.DestinationsBean> americaList = new ArrayList<>();
    List<Country.DestinationsBean> hktList = new ArrayList<>();
    List<Country.DestinationsBean> chinaList = new ArrayList<>();
    Handler handler;
    private MyDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.raiders_fragment, container, false);
        dialog = MyDialog.creatDialog(getActivity(), "加载中...");
        dialog.show();


        initView();
        UrlStr();
        initData();






        return view;
    }

    @Override
    public void onStart() {


        super.onStart();
    }

    private void initView() {
        //浏览
        scan = (NoScrollGridView) view.findViewById(R.id.scan_text);
        //亚洲
        asia = (NoScrollGridView) view.findViewById(R.id.asia_view);
        //欧洲
        europe = (NoScrollGridView) view.findViewById(R.id.europe_view);
        //美洲
        america = (NoScrollGridView) view.findViewById(R.id.america_view);
        //港澳台
        hkt = (NoScrollGridView) view.findViewById(R.id.hkt_view);
        //大陆
        china = (NoScrollGridView) view.findViewById(R.id.china_view);


        scanAdapter = new ScanAdapter(getActivity(), addressList);
        scan.setAdapter(scanAdapter);
    }
    private void initData() {

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();

                if (msg.what == 300){

                    adapter = new CountryAdapter(getActivity(), asiaList);
                    asia.setAdapter(adapter);


                    adapter = new CountryAdapter(getActivity(), europeList);
                    europe.setAdapter(adapter);

                    adapter = new CountryAdapter(getActivity(), americaList);
                    america.setAdapter(adapter);



                    adapter = new CountryAdapter(getActivity(), hktList);
                    hkt.setAdapter(adapter);


                    adapter = new CountryAdapter(getActivity(), chinaList);
                    china.setAdapter(adapter);

                }








                return false;
            }
        });





        itemClick();



    }


    public void itemClick(){
        asia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country = asiaList.get(position).getName_zh_cn().toString();
                String ids = asiaList.get(position).getId();
                addressList.add(0,country);
                scanAdapter.scanChangeAdapter(addressList);
                Intent intent = new Intent(getActivity(), CountryBriefActivity.class);
                intent.putExtra("id",ids);
                intent.putExtra("country",country);
                startActivity(intent);
            }
        });

        europe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country = europeList.get(position).getName_zh_cn().toString();
                String ids = europeList.get(position).getId();
                addressList.add(0,country);
                scanAdapter.scanChangeAdapter(addressList);
                Intent intent = new Intent(getActivity(), CountryBriefActivity.class);
                intent.putExtra("id",ids);
                intent.putExtra("country",country);
                startActivity(intent);
            }
        });


        america.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country = americaList.get(position).getName_zh_cn().toString();
                String ids = americaList.get(position).getId();
                addressList.add(0,country);
                scanAdapter.scanChangeAdapter(addressList);
                Intent intent = new Intent(getActivity(), CountryBriefActivity.class);
                intent.putExtra("id",ids);
                intent.putExtra("country",country);
                startActivity(intent);
            }
        });


        hkt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country = hktList.get(position).getName_zh_cn().toString();
                String ids = hktList.get(position).getId();
                addressList.add(0,country);
                scanAdapter.scanChangeAdapter(addressList);
                Intent intent = new Intent(getActivity(), CountryBriefActivity.class);
                intent.putExtra("id",ids);
                intent.putExtra("country",country);
                startActivity(intent);
            }
        });


        china.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country = chinaList.get(position).getName_zh_cn().toString();
                String ids = chinaList.get(position).getId();
                addressList.add(0,country);
                scanAdapter.scanChangeAdapter(addressList);
                Intent intent = new Intent(getActivity(), CountryBriefActivity.class);
                intent.putExtra("id",ids);
                intent.putExtra("country",country);
                startActivity(intent);
            }
        });

    }

    public void UrlStr(){


        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(raidersUrl, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {

                        Gson gson = new Gson();
                        countryList = gson.fromJson(result,
                                new TypeToken<List<Country>>(){}.getType());

                        for (Country c : countryList){
                            switch (c.getCategory()){
                                case "1":
                                    asiaList = c.getDestinations();

                                    break;
                                case "2":
                                    europeList = c.getDestinations();

                                    break;
                                case "3":
                                    americaList = c.getDestinations();
                                    break;
                                case "99":
                                    hktList = c.getDestinations();
                                    break;
                                case "999":
                                    chinaList = c.getDestinations();
                                    break;
                            }



                        }


                        handler.sendEmptyMessage(300);


                    }
                });
            }
        }).start();
    }



}
