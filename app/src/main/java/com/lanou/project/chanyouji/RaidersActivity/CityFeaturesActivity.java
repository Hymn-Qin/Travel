package com.lanou.project.chanyouji.RaidersActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityFeatures;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.RaidersAdapter.CityFeaturesAdapter;
import com.lanou.project.chanyouji.utils.HttpUtils;

import java.util.List;

public class CityFeaturesActivity extends AppCompatActivity {

    //https://chanyouji.com/api/articles.json?destination_id=55&page=1
    String url1 = "http://chanyouji.com/api/articles.json?destination_id=";
    String url3 = "&page=1";
    String url2 = "";
    String urlPath = "";
    String cityName = "";
    String cityABC = "";
    List<CityFeatures> cityFeaturesList;
    Handler handler;
    CityFeaturesAdapter adapter;
    ListView listView;
    TextView cityTitle;
    LinearLayout linearLayout;

    MyDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_features);
        dialog= MyDialog.creatDialog(this,"加载中...");
        dialog.show();
        Intent intent = getIntent();
        url2 = intent.getStringExtra("id");
        cityName = intent.getStringExtra("city");
        cityABC = intent.getStringExtra("cityABC");
        urlPath = url1 + url2 + url3;
        listView = (ListView) findViewById(R.id.city_features_listview);
        cityTitle = (TextView) findViewById(R.id.brief_title);
        cityTitle.setText(cityName + "专题");
        linearLayout = (LinearLayout) findViewById(R.id.back_back);


        UrlPath();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.dismiss();

                    adapter = new CityFeaturesAdapter(getApplicationContext(), cityFeaturesList);
                    listView.setAdapter(adapter);
                }
                return false;
            }
        });



        Clicks();
    }

    private void Clicks() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void UrlPath() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("CityFeaturesActivity", urlPath);
                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();

                        cityFeaturesList = gson.fromJson(result,
                                new TypeToken<List<CityFeatures>>(){}.getType());
                        Log.d("CityFeaturesActivity", "cityFeaturesList.size():" + cityFeaturesList.size());
                        handler.sendEmptyMessage(200);
                    }
                });
            }
        }).start();
    }
}
