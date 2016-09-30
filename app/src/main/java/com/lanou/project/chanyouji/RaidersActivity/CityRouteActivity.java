package com.lanou.project.chanyouji.RaidersActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityRaiders;
import com.lanou.project.chanyouji.Raiders.CityRoute;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.RaidersAdapter.CityRouteAdapter;
import com.lanou.project.chanyouji.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class CityRouteActivity extends AppCompatActivity {

    //https://chanyouji.com/api/destinations/plans/45.json?page=1

    String url1 = "http://chanyouji.com/api/destinations/plans/";
    String url2 = ".json?page=1";
    String urlPath = "";
    List<CityRoute> cityRouteList;
    CityRouteAdapter adapter;
    Handler handler;
    RecyclerView recyclerView;
    TextView textView;

    LinearLayout l;
    private MyDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_route);
        dialog = MyDialog.creatDialog(this, "加载中...");
        dialog.show();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String cityName = intent.getStringExtra("city");
        urlPath = url1 + id + url2;
        recyclerView = (RecyclerView) findViewById(R.id.route_recycler);

        textView = (TextView) findViewById(R.id.brief_title);
        textView.setText(cityName+ "行程");

        l = (LinearLayout) findViewById(R.id.back_back);


        urlPath();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {


                if (msg.what == 600){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.dismiss();
                    adapter = new CityRouteAdapter(getApplicationContext(), cityRouteList);
                    recyclerView.setAdapter(adapter);

                }
                return false;
            }
        });


        LinearLayoutManager manager_v = new LinearLayoutManager(this);
        manager_v.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager_v);

        Clicks();

    }

    private void Clicks() {

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void urlPath(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        cityRouteList = gson.fromJson(result,
                                new TypeToken<List<CityRoute>>(){}.getType());
                        Log.d("CityRouteActivity", "cityRouteList.size():" + cityRouteList.size());


                        handler.sendEmptyMessage(600);
                    }
                });


            }
        }).start();
    }
}
