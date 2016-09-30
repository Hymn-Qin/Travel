package com.lanou.project.chanyouji.RaidersActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityTravelItem;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.Raiders.MyExpandableListView;
import com.lanou.project.chanyouji.Raiders.MyScrollView;
import com.lanou.project.chanyouji.RaidersAdapter.CityTravelItemEXListAdapter;
import com.lanou.project.chanyouji.utils.HttpUtils;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CityTravelListItemActivity extends AppCompatActivity {

    //https://chanyouji.com/api/attractions/35443.json
    String idScenic;
    String url1 = "http://chanyouji.com/api/attractions/";
    String url2 = ".json";
    String urlPath;
    MyScrollView myScrollView;
    RelativeLayout linear, tab;
    LinearLayout tabT, travel_nearby_LL, hotel_nearby_LL, tujimap;
    TextView titleText, titleABCText, photoNum, jiNum, jieshaoText, shiyongText, travelNum, hotelNum, tiG;
    ImageView titleImage, titleBgImage, bgImage;
    MyExpandableListView exListView;
    CityTravelItemEXListAdapter adapter;
    List<CityTravelItem.AttractionTripTagsBean> attractionTripTagsBeanList;


    RelativeLayout one;
    int oneY;
    int tabTY;
    int titleImageY;
    int jieshaoTextY;
    int tujimapY;

    CityTravelItem cityTravelItem;

    Handler handler;

    MyDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_travel_list_item);
        dialog = MyDialog.creatDialog(this,"加载中...");
        dialog.show();
        myScrollView = (MyScrollView) findViewById(R.id.travel_myScrollView);
        linear = (RelativeLayout) findViewById(R.id.travel_list_item_tab);
        linear.setVisibility(View.GONE);

        Intent intent = getIntent();
        idScenic = intent.getStringExtra("idScenic");
        urlPath = url1 + idScenic + url2;

        initView();
        initData();
        UrlPath();






    }

    private void initView() {
        //标题
        titleText = (TextView) findViewById(R.id.travel_item_title);
        //英文
        titleABCText = (TextView) findViewById(R.id.travel_item_title_ABC);
        //图片数目
        photoNum = (TextView) findViewById(R.id.travel_item_photo);
        //有机数目
        jiNum = (TextView) findViewById(R.id.travel_item_ji);
        //简单介绍
        jieshaoText = (TextView) findViewById(R.id.jieshao);
        //实用贴士
        shiyongText = (TextView) findViewById(R.id.one_text);
        exListView = (MyExpandableListView) findViewById(R.id.ex_listview);
        //附近景点
        travelNum = (TextView) findViewById(R.id.travel_num);
        //附近酒店
        hotelNum = (TextView) findViewById(R.id.hotel_num);
        //滑动标签
        tab = (RelativeLayout) findViewById(R.id.travel_list_item_tab);
        tab.setAlpha(1);

        one = (RelativeLayout) findViewById(R.id.one);

        tabT = (LinearLayout) findViewById(R.id.travel_list_item_tab_title);
        travel_nearby_LL = (LinearLayout) findViewById(R.id.travel_nearby_LL);
        hotel_nearby_LL = (LinearLayout) findViewById(R.id.hotel_nearby_LL);
        tujimap = (LinearLayout) findViewById(R.id.tu_ji_map);



        //
        titleImage = (ImageView) findViewById(R.id.travel_item_title_image);
        titleBgImage = (ImageView) findViewById(R.id.beijing);
        bgImage = (ImageView) findViewById(R.id.bg_image);

        tiG = (TextView) findViewById(R.id.travel_item_group);
    }

    private void initData() {

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200){



                    titleText.setText(cityTravelItem.getName_zh_cn());
                    titleABCText.setText(cityTravelItem.getName_en());
                    photoNum.setText("图片 " + cityTravelItem.getPhotos_count());
                    jiNum.setText("游记 " + cityTravelItem.getAttraction_trips_count());
                    jieshaoText.setText(cityTravelItem.getDescription());
                    Spanned shiyong = Html.fromHtml(cityTravelItem.getTips_html());
                    shiyongText.setText(shiyong);
                    Picasso.with(getApplicationContext())
                            .load(cityTravelItem.getImage_url())
                            .resize(590,350)//加载图片大小
                            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                            .into(titleImage);
                    Picasso.with(getApplicationContext())
                            .load(cityTravelItem.getImage_url())
                            .resize(100,50)//加载图片大小
                            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                            .into(bgImage);
                    bgImage.setVisibility(View.GONE);
                    titleBgImage.getBackground().setAlpha(50);
                    attractionTripTagsBeanList = cityTravelItem.getAttraction_trip_tags();
                    adapter = new CityTravelItemEXListAdapter(getApplicationContext(), attractionTripTagsBeanList);

                    exListView.setFocusable(false);
                    exListView.setGroupIndicator(null);
                    exListView.setAdapter(adapter);
                    for (int i = 0; i < attractionTripTagsBeanList.size(); i++) {
                        exListView.expandGroup(i);
                    }
                    List<CityTravelItem.AttractionsBean> attractionsList = cityTravelItem.getAttractions();
                    List<CityTravelItem.HotelsBean> hotelsList = cityTravelItem.getHotels();

                    travelNum.setText(attractionsList.size()+"");
                    hotelNum.setText(hotelsList.size()+"");
                    travel_nearby_LL.removeAllViews();
                    for (CityTravelItem.AttractionsBean attractions : attractionsList) {

                        String imageUrl = attractions.getImage_url();
                        String name = attractions.getName_zh_cn();
                        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_city_travel_list_item_sc_travel_image, null);
                        ImageView imageView = (ImageView) view.findViewById(R.id.travel_item_sc_image_view);
                        TextView textView = (TextView) view.findViewById(R.id.travel_item_sc_image_text);
                        TextView travelName = (TextView) view.findViewById(R.id.travel_item_sc_travel_name);


                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(250, 250);
                        view.setLayoutParams(params);
                        textView.setText(0.1 +"k");
                        travelName.setText(name);
                        Picasso.with(getApplicationContext())
                                .load(imageUrl)
                                .resize(350, 320)//加载图片大小
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .into(imageView);
                        travel_nearby_LL.addView(view);
                    }


                    hotel_nearby_LL.removeAllViews();
                    for (CityTravelItem.HotelsBean hotels : hotelsList) {

                        String imageUrl = hotels.getImage_url();
                        String name = hotels.getName_zh_cn();
                        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_city_travel_list_item_sc_travel_image, null);
                        ImageView imageView = (ImageView) view.findViewById(R.id.travel_item_sc_image_view);
                        TextView textView = (TextView) view.findViewById(R.id.travel_item_sc_image_text);
                        TextView travelName = (TextView) view.findViewById(R.id.travel_item_sc_travel_name);

                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(250, 250);
                        view.setLayoutParams(params);
                        textView.setText(0.1 +"k");
                        travelName.setText(name);
                        Picasso.with(getApplicationContext())
                                .load(imageUrl)
                                .resize(350, 320)//加载图片大小
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                .into(imageView);
                        hotel_nearby_LL.addView(view);
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    dialog.dismiss();

                    exListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {



                            return false;
                        }
                    });
                }

                return false;
            }
        });

        myScrollView.setScrollViewListener(new MyScrollView.ScrollViewListener() {

            @Override
            public void sendDistanceY(int distance) {

                if (distance >= titleImageY - tabTY){
                    bgImage.setVisibility(View.VISIBLE);
                }else {
                    bgImage.setVisibility(View.GONE);
                }
                if (distance >=  tujimapY + jieshaoTextY + titleImageY - tabTY){
                    linear.setVisibility(View.VISIBLE);
//                    tiG.setText(one.getT);
//                    myScrollView.getChildAt(0)
                }else {
                    linear.setVisibility(View.GONE);
                }


            }
        });



    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){

            oneY = one.getMeasuredHeight();
            Log.d("CityTravelListItemActiv", "oneY:" + oneY);
            tabTY = tabT.getHeight();
            titleImageY = titleImage.getMeasuredHeight();

            jieshaoTextY = jieshaoText.getMeasuredHeight();
            tujimapY = tujimap.getMeasuredHeight();



        }

    }

    public void UrlPath(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {

                        Gson gson = new Gson();
                        cityTravelItem = gson.fromJson(result, new TypeToken<CityTravelItem>(){}.getType());

                        handler.sendEmptyMessage(200);
                    }
                });
            }
        }).start();
    }




}
