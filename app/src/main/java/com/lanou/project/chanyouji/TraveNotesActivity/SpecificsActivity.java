package com.lanou.project.chanyouji.TraveNotesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.Adapter.ExpandableAdapter;
import com.lanou.project.chanyouji.Class.Node;
import com.lanou.project.chanyouji.Class.TraveiNotes;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.HttpUtils;
import com.lanou.project.chanyouji.utils.Parse;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class SpecificsActivity extends AppCompatActivity {
    String uri1 = "http://chanyouji.com/api/trips/";
    String uri2;
    String uri3 = ".json";
    String uri;
    Handler handler;
    ExpandableListView expandListView;
    ExpandableAdapter apter;
    List<Node>nodeList;
    TraveiNotes traveiNotes;
    ImageView front_cover_photo_url,image;
    TextView name,start_date,days,photos_count;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifics);
        Intent intent = getIntent();
        uri2 = intent.getStringExtra("id");
        traveiNotes= (TraveiNotes) intent.getSerializableExtra("hao");
        initView();
        initData();
        initListen();
    }


    private void initView() {
        expandListView = (ExpandableListView) findViewById(R.id.expand_listview);
        view=getLayoutInflater().inflate(R.layout.expandlistew_heard,null);
        front_cover_photo_url = (ImageView)view.findViewById(R.id.front_cover_photo_url);
        image = (CircleImageView)view.findViewById(R.id.image);
        name = (TextView) view.findViewById(R.id.name);
        start_date = (TextView) view.findViewById(R.id.start_date);
        days = (TextView) view.findViewById(R.id.days);
        photos_count = (TextView) view.findViewById(R.id.photos_count);

    }
    private void initData() {
        uri = uri1 + uri2 + uri3;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String obj = HttpUtils.doGet(uri);
                nodeList=Parse.getnodeList(obj);
                handler.sendEmptyMessage(200);
            }
        }).start();
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (message.what == 200) {
                    apter=new ExpandableAdapter(SpecificsActivity.this,nodeList);
                    expandListView.setAdapter(apter);
                    expandListView.addHeaderView(view);
                    for(int i = 0; i < apter.getGroupCount(); i++){
                        expandListView.expandGroup(i);
                    }

                }
                return false;

            }
        });
        ImageLoader.getInstance().displayImage(traveiNotes.getFront_cover_photo_url(),front_cover_photo_url);
        ImageLoader.getInstance().displayImage(traveiNotes.getUser().getImage(),image);
        name.setText(traveiNotes.getName());
        start_date.setText(traveiNotes.getStart_date());
        days.setText(traveiNotes.getDays());
        photos_count.setText(traveiNotes.getPhotos_count());

    }
    private void initListen() {
        expandListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }
            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

    }
}
