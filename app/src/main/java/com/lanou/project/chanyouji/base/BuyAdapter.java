package com.lanou.project.chanyouji.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou.project.chanyouji.ToolActivity.BuyContext;
import com.lanou.project.chanyouji.R;

import java.util.List;

/**
 * Created by lanouhn on 16/9/26.
 */
public class BuyAdapter extends BaseAdapter {

   List<BuyContext> byList;
    private Context context;

    public  BuyAdapter (Context context,List<BuyContext> byList){
        this.context=context;
        this.byList=byList;
    }
    public void setChangeBuyAdapter (Context context,List<BuyContext> byList){
        this.context=context;
        this.byList=byList;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return byList!=null?byList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return byList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         MyHolder myHolder=null;
        if (convertView==null){
            myHolder=new MyHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.xiaofeijilu,null);
            myHolder.money= (TextView) convertView.findViewById(R.id.by_item_note_money);
            myHolder.type= (TextView) convertView.findViewById(R.id.by_brand_name);
            myHolder.xiang= (TextView) convertView.findViewById(R.id.by_item_note_content);

            convertView.setTag(myHolder);
        }else {
            myHolder= (MyHolder) convertView.getTag();
        }
        myHolder.money.setText( byList.get(position).getMoney()+","+byList.get(position).getCoin());
        myHolder.type.setText(byList.get(position).getType());
        myHolder.xiang.setText(byList.get(position).getTime() +","+byList.get(position).getXiang());
        return convertView;
    }


    class  MyHolder{
        TextView money,coin,type,xiang,time,sumMoney;
    }
    public void SetData(List<BuyContext> byList){
        this.byList=byList;
        notifyDataSetChanged();
    }
}
