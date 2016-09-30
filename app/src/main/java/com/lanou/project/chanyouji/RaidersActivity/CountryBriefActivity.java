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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CountryBrief;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.RaidersAdapter.BriefRecyclerAdapter;
import com.lanou.project.chanyouji.utils.HttpUtils;

import java.util.List;

public class CountryBriefActivity extends AppCompatActivity {

    String url1 = "http://chanyouji.com/api/destinations/";
    String id;
    String urlPath;
    List<CountryBrief> briefList;
    Handler handler;
    RecyclerView briefRecycler;
    BriefRecyclerAdapter adapter;

    TextView textView;
    ImageView  fenxiangImage;
    LinearLayout back;
    private MyDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_brief);



        briefRecycler = (RecyclerView) findViewById(R.id.brief_recycler);
        textView = (TextView) findViewById(R.id.brief_title);
        back = (LinearLayout) findViewById(R.id.back_back);

        dialog = MyDialog.creatDialog(this, "加载中...");
        dialog.show();
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        textView.setText(intent.getStringExtra("country") + "攻略");
        urlPath = url1 + id + ".json";
        Log.d("CountryBriefActivity", urlPath);

        UrlStr();


        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
                if (msg.what == 400){
                    adapter = new BriefRecyclerAdapter(CountryBriefActivity.this, briefList);
                    briefRecycler.setAdapter(adapter);
                }


                return false;
            }
        });


        LinearLayoutManager manager_v = new LinearLayoutManager(this);
        manager_v.setOrientation(LinearLayoutManager.VERTICAL);
        briefRecycler.setLayoutManager(manager_v);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void UrlStr() {

        new Thread(new Runnable() {
            @Override
            public void run() {




                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        briefList = gson.fromJson(result,
                                new TypeToken<List<CountryBrief>>(){}.getType());

                        Log.d("CountryBriefActivity", "briefList.size():" + briefList.size());


                        handler.sendEmptyMessage(400);
                    }
                });
            }


        }).start();
    }
}
