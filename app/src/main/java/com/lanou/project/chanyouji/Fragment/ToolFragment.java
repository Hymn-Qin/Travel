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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.ToolActivity.CityActivity;
import com.lanou.project.chanyouji.ToolActivity.JiLuActivity;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.ToolActivity.RateToolActivity;
import com.lanou.project.chanyouji.ToolActivity.ToolMapActivity;
import com.lanou.project.chanyouji.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lanouhn on 16/9/14.
 */
public class ToolFragment extends Fragment {

    TextView day_min, day_max, day_time, tool_text;
    Button button;
    Handler handler;
    ImageView lvyou,lvMoney,lvmap;

    List<Integer> dayList;
    View view;
    int id;
    String name;
    String uri1 = "http://chanyouji.com/api/wiki/destinations/infos/";
    String uri3 = ".json?page=1";
    String uri;
    String max, min;
    String time,code,display;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_tool, container, false);
        button = (Button) view.findViewById(R.id.tool_b);
        tool_text = (TextView) view.findViewById(R.id.tool_text);
        day_max = (TextView) view.findViewById(R.id.day_max);
        day_min = (TextView) view.findViewById(R.id.day_min);
        day_time = (TextView) view.findViewById(R.id.day_time);
        lvyou= (ImageView) view.findViewById(R.id.iv_toolbox_travel);
        lvMoney= (ImageView) view.findViewById(R.id.iv_toolbox_rate);
        lvmap= (ImageView) view.findViewById(R.id.iv_toolbox_map);

        lvyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), JiLuActivity.class);
                startActivity(intent);
            }
        });

        tool_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CityActivity.class);
                startActivityForResult(intent, 200);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CityActivity.class);
                startActivityForResult(intent, 200);
            }
        });

        lvMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), RateToolActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("currency_code",code);
                intent.putExtra("currency_display",display);
                startActivity(intent);
            }
        });


        lvmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ToolMapActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == 201) {
                view.findViewById(R.id.rela_f).setVisibility(View.GONE);
                view.findViewById(R.id.sssss).setVisibility(View.VISIBLE);
                initEvent();
                id = data.getIntExtra("id", 0);
                name = data.getStringExtra("name");
                uri = uri1 + id + uri3;
                handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        if (msg.what == 110) {
                            day_max.setText(max);
                            day_min.setText(min);
                            day_time.setText(time);
                            tool_text.setText(name);
                            onResume();
                        }
                        return false;
                    }
                });
            }
        }
    }

    public void initEvent() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpUtils.doGetAsyn(uri, new HttpUtils.CallBack() {


                    @Override
                    public void onRequestComplete(String result) {
                        try {
                            JSONObject jso = new JSONObject(result);
                            dayList = new ArrayList<>();
                            if (jso.has("temp_min")) {
                                String temp_min = jso.getString("temp_min");
                                min = temp_min;
                            }
                            if (jso.has("temp_max")) {
                                String temp_max = jso.getString("temp_max");
                                max = temp_max;
                            }
                            if (jso.has("current_time")) {
                                String current_time = jso.getString("current_time");
                                time = current_time;
                            }
                            if(jso.has("currency_code")){
                                String current_code=jso.getString("currency_code");
                                code=current_code;
                            }
                            if (jso.has("currency_display")){
                                String current_display=jso.getString("currency_display");
                                display=current_display;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(110);
                    }


                });
            }
        }).start();
    }

}

