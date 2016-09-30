package com.lanou.project.chanyouji.RaidersActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.ChlidrenBean;
import com.lanou.project.chanyouji.Raiders.CityRaiders;
import com.lanou.project.chanyouji.Raiders.Country;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.Raiders.NoScrollGridView;
import com.lanou.project.chanyouji.RaidersAdapter.CityRaidersAdpter;
import com.lanou.project.chanyouji.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityRaidersActivity extends AppCompatActivity {


    String id ;
    String urlPath = "";
    String url1 = "http://chanyouji.com/api/wiki/destinations/";
    String url2 = ".json";

    TextView cityView, textView;
    LinearLayout back;

    String cityTitle;
    String cityABC;
    Handler handler;
    List<CityRaiders> cityRaidersList;
    List<CityRaiders.PagesBean> overviewList, noteList,
            arriveList, trafficList, hotelList,
            foodList, shoppingList, departureList,
            otherList, entertainmentList, attractionList;
    List<CityRaiders.PagesBean.ChildrenBean> childrenList;
    NoScrollGridView overView, noteView, arriveView,
            trafficView, hotelView, foodView,
            shoppingView, departureView, otherView, entertainmentView , attractionView;
    CityRaidersAdpter adapter;


    private MyDialog dialog ;

    RelativeLayout overview_R, note_R,
            arrive_R, traffic_R, hotel_R,
            food_R, shopping_R, departure_R,
            other_R, entertainment_R, attraction_R;


    RelativeLayout look_rl;
    String itemId;
    String itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_raiders);


        dialog = MyDialog.creatDialog(this, "加载中...");
        dialog.show();
        Intent intent = getIntent();
        cityABC = intent.getStringExtra("cityABC");
        id = intent.getStringExtra("id");
        urlPath = url1 + id + url2;
        cityTitle = intent.getStringExtra("city");
        cityView = (TextView) findViewById(R.id.brief_title);
        cityView.setText(cityTitle + "攻略");
        textView = (TextView) findViewById(R.id.old_look);
        look_rl = (RelativeLayout) findViewById(R.id.look_rl);
        back = (LinearLayout) findViewById(R.id.back_back);
        overView = (NoScrollGridView) findViewById(R.id.overview);
        noteView = (NoScrollGridView) findViewById(R.id.noteview);
        arriveView = (NoScrollGridView) findViewById(R.id.Arriveview);
        trafficView = (NoScrollGridView) findViewById(R.id.trafficview);
        attractionView = (NoScrollGridView) findViewById(R.id.attractionview);
        entertainmentView = (NoScrollGridView) findViewById(R.id.entertainmentview);
        hotelView = (NoScrollGridView) findViewById(R.id.hotelview);
        foodView = (NoScrollGridView) findViewById(R.id.foodview);
        shoppingView = (NoScrollGridView) findViewById(R.id.shoppingview);
        departureView = (NoScrollGridView) findViewById(R.id.departureview);
        otherView = (NoScrollGridView) findViewById(R.id.otherview);

        overview_R = (RelativeLayout) findViewById(R.id.over_R);
        note_R = (RelativeLayout) findViewById(R.id.note_R);
        arrive_R = (RelativeLayout) findViewById(R.id.arrive_R);
        traffic_R = (RelativeLayout) findViewById(R.id.traffic_R);
        hotel_R = (RelativeLayout) findViewById(R.id.hotel_R);
        food_R = (RelativeLayout) findViewById(R.id.food_R);
        shopping_R = (RelativeLayout) findViewById(R.id.shopping_R);
        departure_R = (RelativeLayout) findViewById(R.id.shopping_R);
        other_R = (RelativeLayout) findViewById(R.id.other_R);
        entertainment_R = (RelativeLayout) findViewById(R.id.entertainment_R);
        attraction_R = (RelativeLayout) findViewById(R.id.attraction_R);



        UrlPath();
        initData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initData() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 500){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.dismiss();

                    if (overviewList != null){
                        overview_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), overviewList);
                        overView.setAdapter(adapter);
                    }


                    if (noteList != null){
                        note_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), noteList);
                        noteView.setAdapter(adapter);
                    }

                    if (arriveList != null){
                        arrive_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), arriveList);
                        arriveView.setAdapter(adapter);
                    }

                    if (trafficList != null){
                        traffic_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), trafficList);
                        trafficView.setAdapter(adapter);
                    }


                    if (attractionList != null){
                        attraction_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), attractionList);
                        attractionView.setAdapter(adapter);
                    }

                    if (entertainmentList != null){
                        entertainment_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), entertainmentList);
                        entertainmentView.setAdapter(adapter);
                    }

                    if (hotelList != null){
                        hotel_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), hotelList);
                        hotelView.setAdapter(adapter);
                    }

                    if (foodList != null){
                        food_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), foodList);
                        foodView.setAdapter(adapter);
                    }


                    if (shoppingList != null){
                        shopping_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), shoppingList);
                        shoppingView.setAdapter(adapter);

                    }

                    if (departureList != null){
                        departure_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), departureList);
                        departureView.setAdapter(adapter);
                    }

                    if (otherList != null){
                        other_R.setVisibility(View.VISIBLE);
                        adapter = new CityRaidersAdpter(getApplicationContext(), otherList);
                        otherView.setAdapter(adapter);
                    }


                    clickItem();
                }

                return false;
            }
        });




    }

    private void clickItem() {
        look_rl.setVisibility(View.VISIBLE);
        look_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() != null && textView.length() != 0) {
                    Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                    intent.putExtra("itemId", itemId);
                    intent.putExtra("itemName", itemName);
                    intent.putExtra("cityABC", cityABC);
                    intent.putExtra("city", cityTitle);
                    intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);
                    startActivity(intent);
                }
            }
        });

        overView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = overviewList.get(position).getId();
                itemName = overviewList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);

                childrenList = overviewList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);




                startActivity(intent);



            }
        });

        noteView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = noteList.get(position).getId();
                itemName = noteList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = noteList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        arriveView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = arriveList.get(position).getId();
                itemName = arriveList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = arriveList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        trafficView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = trafficList.get(position).getId();
                itemName = trafficList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = trafficList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);


                startActivity(intent);



            }
        });

        attractionView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = attractionList.get(position).getId();
                itemName = attractionList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = attractionList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        entertainmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = entertainmentList.get(position).getId();
                itemName = entertainmentList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = entertainmentList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        hotelView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = hotelList.get(position).getId();
                itemName = hotelList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = hotelList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        foodView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = foodList.get(position).getId();
                itemName = foodList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = foodList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        shoppingView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = shoppingList.get(position).getId();
                itemName = shoppingList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = shoppingList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);

                startActivity(intent);



            }
        });

        departureView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = departureList.get(position).getId();
                itemName = departureList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = departureList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);



                startActivity(intent);



            }
        });

        otherView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemId = otherList.get(position).getId();
                itemName = otherList.get(position).getTitle();
                textView.setText(itemName);
                Intent intent = new Intent(getApplicationContext(), CityRaidersItemActivity.class);
                intent.putExtra("itemId",itemId);
                intent.putExtra("itemName",itemName);
                intent.putExtra("cityABC",cityABC);
                intent.putExtra("city", cityTitle);
                childrenList = otherList.get(position).getChildren();
                intent.putParcelableArrayListExtra("childrenList", (ArrayList<? extends Parcelable>) childrenList);

                startActivity(intent);



            }
        });




    }


    public void UrlPath(){


        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        cityRaidersList = gson.fromJson(result,
                                new TypeToken<List<CityRaiders>>(){}.getType());

                        for (CityRaiders cityRaiders : cityRaidersList){
                            switch (cityRaiders.getCategory_type()){
                                case 0:
                                    overviewList = cityRaiders.getPages();
                                    break;
                                case 1:
                                    noteList = cityRaiders.getPages();
                                    break;
                                case 2:
                                    arriveList = cityRaiders.getPages();
                                    break;
                                case 3:
                                    trafficList = cityRaiders.getPages();
                                    break;
                                case 4:
                                    attractionList = cityRaiders.getPages();
                                    break;
                                case 5:
                                    entertainmentList = cityRaiders.getPages();
                                    break;
                                case 6:
                                    hotelList = cityRaiders.getPages();
                                    break;
                                case 7:
                                    foodList = cityRaiders.getPages();
                                    break;
                                case 8:
                                    shoppingList = cityRaiders.getPages();
                                    break;
                                case 9:
                                    departureList = cityRaiders.getPages();
                                    break;
                                case 11:
                                    otherList = cityRaiders.getPages();
                                    break;
                            }
                        }

                        handler.sendEmptyMessage(500);

                    }
                });


            }
        }).start();

    }



}
