package com.lanou.project.chanyouji.TraveNotesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.Adapter.ViewPagerAdapter;
import com.lanou.project.chanyouji.Class.Auteur;
import com.lanou.project.chanyouji.Class.Trips;
import com.lanou.project.chanyouji.Fragment.AuthoroneFragment;
import com.lanou.project.chanyouji.Fragment.AuthortwoFragment;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.HttpUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class WriterActivity extends AppCompatActivity {
    String uir1="http://chanyouji.com/api/users/";
    String uir2;
    String uir3=".json?page=";
    int uir4=1;
    TextView name1,name,trips_count;
    CircleImageView image;
    TabLayout tab;
    ViewPager vp;
    Auteur auteur=new Auteur();
    List<Trips> tripsbentList;
    Handler handler;
    List<Fragment> fragmentList;
    List<String> stringList;
    ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer);
        Intent intent=getIntent();
        uir2=intent.getStringExtra("id");
        initView();
        initData();
    }
    private void initView() {
        name1 = (TextView) findViewById(R.id.name1);
        name = (TextView) findViewById(R.id.name);
        trips_count = (TextView) findViewById(R.id.trips_count);
        image = (CircleImageView) findViewById(R.id.image);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
    }
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String uri=uir1+uir2+uir3+uir4;
               String obj= HttpUtils.doGet(uri);
                Gson gson=new Gson();
                String obj1=null;
                try {
                    JSONObject object=new JSONObject(obj);
                    if (object.has("trips_count")){
                        auteur.setTrips_count(object.getString("trips_count"));
                    }
                    if (object.has("name")){
                        auteur.setName(object.getString("name"));
                    }
                    if (object.has("image")){
                        auteur.setImage(object.getString("image"));
                    }
                    if (object.has("trips")){
                        obj1=object.getString("trips");
                    }
                    if (object.has("id")){
                        auteur.setId(object.getInt("id"));
                    }
                    tripsbentList=gson.fromJson(obj1,new
                            TypeToken<List<Trips>>(){}.getType());
                    handler.sendEmptyMessage(200);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (message.what==200){
                    name1.setText(auteur.getName());
                    name.setText(auteur.getName());
                    trips_count.setText(auteur.getTrips_count()+"篇");
                    ImageLoader.getInstance().displayImage
                            (auteur.getImage(),image);
                    getViewPager();
                }
                return false;
            }
        });
    }
    private void getViewPager() {
        fragmentList=new ArrayList<>();
        AuthoroneFragment authorone=new AuthoroneFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelableArrayList("made", (ArrayList<? extends Parcelable>) tripsbentList);
        authorone.setArguments(bundle);
        fragmentList.add(authorone);
        AuthortwoFragment authortwo=new AuthortwoFragment();

        bundle.putString("id",uir2);
        authortwo.setArguments(bundle);
        fragmentList.add(authortwo);
        stringList=new ArrayList<>();
        stringList.add("游记");
        stringList.add("喜欢");
        adapter=new ViewPagerAdapter
                (getSupportFragmentManager(),fragmentList,stringList);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

}
