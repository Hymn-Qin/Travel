package com.lanou.project.chanyouji.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lanou.project.chanyouji.Class.Photo;
import com.lanou.project.chanyouji.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;



/**
 * Created by lanouhn on 16/9/27.
 */
public class AuthortwoAdapter extends BaseAdapter {
    List<Photo> photoList;
    Context context;
    public AuthortwoAdapter(Context context, List<Photo> photoList){
        this.photoList=photoList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int i) {
        return photoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder=null;
        if (view==null){
            holder=new MyViewHolder();
            view= LayoutInflater.from(context).inflate
                    (R.layout.phonto_item,viewGroup,false);
            holder.imageView= (ImageView) view.findViewById(R.id.imageView);

            view.setTag(holder);
        }else {
            holder= (MyViewHolder) view.getTag();
        }
        ImageLoader.getInstance().displayImage
                (photoList.get(i).getPhoto_url(),holder.imageView);
        return view;
    }
    class MyViewHolder{
        ImageView imageView;
    }
}
