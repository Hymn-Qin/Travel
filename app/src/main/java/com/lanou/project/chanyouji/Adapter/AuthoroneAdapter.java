package com.lanou.project.chanyouji.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.Class.Trips;
import com.lanou.project.chanyouji.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;



/**
 * Created by lanouhn on 16/9/22.
 */
public class AuthoroneAdapter extends BaseAdapter {
    List<Trips> tripsbentList;
    Context context;
    public AuthoroneAdapter(Context context, List<Trips> tripsbentList){
        this.context=context;
        this.tripsbentList=tripsbentList;
    }
    @Override
    public int getCount() {
        return tripsbentList!=null?tripsbentList.size():0;
    }

    @Override
    public Object getItem(int i) {
        return tripsbentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Myviewholder holder=null;
        if (view==null){
            holder=new Myviewholder();
            view= LayoutInflater.from(context).inflate(R.layout.tna_item,null);
            holder.front_cover_photo_url= (ImageView) view.findViewById(R.id.front_cover_photo_url);
            holder.days= (TextView) view.findViewById(R.id.days);
            holder.name= (TextView) view.findViewById(R.id.name);
            holder.photos_count= (TextView) view.findViewById(R.id.photos_count);
            holder.start_date= (TextView) view.findViewById(R.id.start_date);
            view.setTag(holder);
        }else {
            holder= (Myviewholder) view.getTag();
        }
        holder.name.setText(tripsbentList.get(i).getName());
        holder.photos_count.setText(tripsbentList.get(i).getPhotos_count()+"图");
        holder.start_date.setText(tripsbentList.get(i).getStart_date()+"/");
        holder.days.setText(tripsbentList.get(i).getDays()+"天");
        ImageLoader.getInstance().displayImage(tripsbentList.get(i).
                getFront_cover_photo_url(),holder.front_cover_photo_url);
        return view;
    }
    class Myviewholder{
         ImageView front_cover_photo_url;
         TextView name,photos_count,start_date,days;
    }
}
