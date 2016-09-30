package com.lanou.project.chanyouji.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.Day;

import java.util.List;

/**
 * Created by lanouhn on 16/9/23.
 */
public class DayAdapter  extends BaseAdapter{
    private List<Day> dayList;
    private Context context;
    View view;
    TextView day_min,day_max,day_time;
    LayoutInflater inflater;
    public DayAdapter (Context context,List<Day> dayList){
        this.context=context;
        this.dayList=dayList;

    }
    @Override
    public int getCount() {
        return dayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        view= inflater.inflate(R.layout.tool_layout,parent,false);
        day_max= (TextView) convertView.findViewById(R.id.day_max);
        day_min= (TextView) convertView.findViewById(R.id.day_min);
        day_time= (TextView) convertView.findViewById(R.id.day_time);

        day_max.setText(dayList.get(position).getTemp_max());
        day_min.setText(dayList.get(position).getTemp_min());
        day_time.setText(dayList.get(position).getCurrent_time());

        return view;
    }
}
