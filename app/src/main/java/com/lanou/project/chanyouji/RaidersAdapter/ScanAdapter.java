package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;

import java.util.List;

/**
 * Created by lanouhn on 16/9/14.
 */
public class ScanAdapter extends BaseAdapter {

    Context context;
    List<String> stringList;

    public ScanAdapter(Context context, List<String> stringList){
        this.context = context;
        this.stringList = stringList;

    }
    public void scanChangeAdapter(List<String> stringList){
        this.stringList = stringList;
        notifyDataSetChanged();

    }







    @Override
    public int getCount() {
        return stringList != null ? stringList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScanViewHolder scanViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.scan_item, null);
            scanViewHolder = new ScanViewHolder();
            scanViewHolder.scan = (TextView) convertView.findViewById(R.id.scan_add);
            convertView.setTag(scanViewHolder);
        }else {
            scanViewHolder = (ScanViewHolder) convertView.getTag();
        }

        scanViewHolder.scan.setText(stringList.get(position));
        return convertView;
    }


    class ScanViewHolder{

        TextView scan;

    }
}
