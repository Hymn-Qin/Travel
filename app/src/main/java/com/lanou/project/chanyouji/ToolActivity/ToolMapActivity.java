package com.lanou.project.chanyouji.ToolActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.lanou.project.chanyouji.R;

public class ToolMapActivity extends Activity implements View.OnClickListener{

   private   ImageView imageView,imageView1;
    TextView textView1,textView2;
    MapView mMapView=null;
    public BaiduMap mBaiduMap=null;
    public LocationClient mLocationClient=null;
    private MyLocationListener myLocationListener;
    private  boolean isFirstLoc=true;
    private Context context;

    private  double mLatitude;
    private  double mLongtitude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_tool_map);


        initView();
        initEvent();


    }




    private void initView() {

        imageView= (ImageView) findViewById(R.id.chan_image3);
        imageView1= (ImageView) findViewById(R.id.back_image3);
        textView1= (TextView) findViewById(R.id.title_text3);
        textView2= (TextView) findViewById(R.id.title_text4);
        mMapView= (MapView) findViewById(R.id.bMapView);

        mBaiduMap=mMapView.getMap();
        MapStatusUpdate msu=MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);
    }
    private void initEvent() {
        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);

        Intent intent=getIntent();
        textView1.setText(intent.getStringExtra("name"));


        mLocationClient=new LocationClient(this);

        myLocationListener=new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);

        LocationClientOption option=new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        option.setCoorType("bd09ll");
        option.setIsNeedAddress(true);
        option.setOpenGps(true);

        option.setScanSpan(1000);
        mLocationClient.setLocOption(option);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.chan_image3:
            case R.id.back_image3:
            case R.id.title_text3:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()){
            mLocationClient.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    private class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {

            MyLocationData data = new MyLocationData.Builder()
                    .accuracy(location.getRadius())//精度
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude())//方向
                    .build();

            mBaiduMap.setMyLocationData(data);
            //自定义图标
            //MyLocationConfiguration config = new MyLocationConfiguration(LocationClientOption.LocationMode,)

            mLatitude = location.getLatitude();
            mLongtitude = location.getLongitude();

            if (isFirstLoc) {
                //设置精度与纬度
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);

                //动画效果
                mBaiduMap.animateMapStatus(msu);
                isFirstLoc = false;

                Toast.makeText(context, location.getAddrStr(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

