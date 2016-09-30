package com.lanou.project.chanyouji.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.Adapter.TravelNotesAdapter;
import com.lanou.project.chanyouji.Class.TraveiNotes;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.TraveNotesActivity.SpecificsActivity;
import com.lanou.project.chanyouji.utils.HttpUtils;
import com.lanou.project.chanyouji.utils.MyListView;

import java.util.Collection;
import java.util.List;



/**
 * Created by lanouhn on 16/9/27.
 */
public class TravelNotesFragment extends Fragment implements MyListView.ILoadLisener{
    View view;
    MyListView listView;
    List<TraveiNotes> traveiNotesList;
    TravelNotesAdapter adater;
    String uri1="http://chanyouji.com/api/trips/featured.json?page=";
    Handler handler;
    int uri2=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.tnf_layout,null);
        initView();
        initData();
        return view;
    }
    private void initView() {
        listView = (MyListView) view.findViewById(R.id.gridview);
        listView.setILoadLisener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), SpecificsActivity.class);
                intent.putExtra("id",traveiNotesList.get(i).getId());
                intent.putExtra("hao",traveiNotesList.get(i));
                getActivity().startActivity(intent);
            }
        });
    }
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
               String uri=uri1+uri2;
               String obj= HttpUtils.doGet(uri);
                Gson gson=new Gson();
                traveiNotesList=gson.fromJson(obj,new
                        TypeToken<List<TraveiNotes>>(){}.getType());
                handler.sendEmptyMessage(200);
            }
        }).start();

        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (message.what==200){
                    adater=new TravelNotesAdapter(getActivity(),traveiNotesList);
                    listView.setAdapter(adater);
                }
                return false;
            }
        });
    }


    @Override
    public void onLoad() {
        initjiazai();

    }

    private void initjiazai() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                uri2+=1;
                String uri=uri1+uri2;
                String obj= HttpUtils.doGet(uri);
                Gson gson=new Gson();
                traveiNotesList.addAll((Collection<? extends TraveiNotes>) gson.fromJson(obj,new
                        TypeToken<List<TraveiNotes>>(){}.getType()));
                int a=200;
                a+=1;
                handler.sendEmptyMessage(a);
            }
        }).start();
        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                int a=200;
                a+=1;
                if (message.what==a){
                    adater.notifyDataSetChanged();
                    listView.loadComplete();
                }
                return false;
            }
        });
    }

}
