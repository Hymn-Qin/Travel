package com.lanou.project.chanyouji.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.Adapter.AuthortwoAdapter;
import com.lanou.project.chanyouji.Class.Photo;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.HttpUtils;

import java.util.List;



/**
 * Created by lanouhn on 16/9/27.
 */
public class AuthortwoFragment extends Fragment {
    String uir1="http://chanyouji.com/api/users/likes/";
    String uri2;
    String uir3=".json?per_page=18&page=1";
    View view;
    String uir;
    GridView gridView;
    List<Photo> photoList;
    Handler handler;
    AuthortwoAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.atf_layout,container,false);
        Bundle bundle=getArguments();
        uri2=bundle.getString("id");
        Log.i("hao",uri2);
        initView();
        initData();
        return view;
    }
    private void initView() {
        gridView= (GridView) view.findViewById(R.id.gridview);

    }
    private void initData() {
          uir=uir1+uri2+uir3;
          Log.i("hao",uir);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String obj= HttpUtils.doGet(uir);
                Gson gson=new Gson();
                photoList=gson.fromJson(obj,new TypeToken<List<Photo>>(){}.getType());
                handler.sendEmptyMessage(200);
            }
        }).start();
        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (message.what==200){
                    adapter=new AuthortwoAdapter(getActivity(),photoList);
                    gridView.setAdapter(adapter);
                }
                return false;
            }
        });

    }

}
