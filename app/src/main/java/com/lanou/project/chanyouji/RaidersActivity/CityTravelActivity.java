package com.lanou.project.chanyouji.RaidersActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lanou.project.chanyouji.Interface.OnViewItemClickListener;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityTravel;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.RaidersAdapter.CityTravelListAdapter;
import com.lanou.project.chanyouji.utils.HttpUtils;

import java.util.List;

public class CityTravelActivity extends AppCompatActivity {
    String url1 = " http://chanyouji.com/api/destinations/attractions/";
    String url2 = ".json?page=";
    int url3 = 1;
    String urlPath = "";
    String id = "";
    XRecyclerView xRecyclerView;
    List<CityTravel> cityTravelList;
    Handler handler;
    CityTravelListAdapter adapter;
    TextView textView;
    LinearLayout linearLayout;
    private MyDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_travel);
        dialog = MyDialog.creatDialog(this, "加载中...");
        dialog.show();

        xRecyclerView = (XRecyclerView) findViewById(R.id.travel_city);
        textView = (TextView) findViewById(R.id.brief_title);
        linearLayout = (LinearLayout) findViewById(R.id.back_back);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
        xRecyclerView.setRefreshing(true);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String cityName = intent.getStringExtra("city");
        textView.setText(cityName + "旅行地");
        urlPath = url1 + id + url2 + url3;





        UrlPath();
        initData();

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void initData() {

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 3000);
                adapter.notifyDataSetChanged();
                xRecyclerView.refreshComplete();
            }



            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        url3 ++;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String urlPathNEW =  url1 + id + url2 + url3;
                                HttpUtils.doGetAsyn(urlPathNEW, new HttpUtils.CallBack() {
                                    @Override
                                    public void onRequestComplete(String result) {
                                        Gson gson = new Gson();
                                        List<CityTravel> cityTravelListNEW = gson.fromJson(result, new
                                                TypeToken<List<CityTravel>>(){}.getType());
                                        for (CityTravel cityTravel : cityTravelListNEW){
                                            cityTravelList.add(cityTravel);
                                        }
                                      handler.sendEmptyMessage(300);
                                    }
                                });
                            }
                        }).start();
                        handler = new Handler(new Handler.Callback() {
                            @Override
                            public boolean handleMessage(Message msg) {
                                if (msg.what == 300){
                                    adapter.setCityTravelList(cityTravelList);
                                    xRecyclerView.loadMoreComplete();
                                }
                                adapter.notifyDataSetChanged();
                                return false;
                            }
                        });
                    }
                }, 0);

            }
        });
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
                    adapter = new CityTravelListAdapter(getApplicationContext(), cityTravelList);
                    xRecyclerView.setAdapter(adapter);


                    adapter.setOnViewItemClickListener(new OnViewItemClickListener() {
                        @Override
                        public void OnItemClick(int position) {
                            String idScenic = cityTravelList.get(position).getId();
                            Intent intent = new Intent(getApplicationContext(), CityTravelListItemActivity.class);
                            intent.putExtra("idScenic",idScenic);
                            startActivity(intent);
                        }
                    });

                }

                return false;
            }
        });


    }

    private void UrlPath() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {

                        Gson gson = new Gson();
                        cityTravelList = gson.fromJson(result, new
                                TypeToken<List<CityTravel>>(){}.getType());

                        handler.sendEmptyMessage(200);
                    }


                });
            }
        }).start();

    }


}
