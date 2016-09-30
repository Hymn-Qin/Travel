package com.lanou.project.chanyouji.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.Class.Tripday;
import com.lanou.project.chanyouji.R;
import com.nostra13.universalimageloader.core.ImageLoader;



/**
 * Created by lanouhn on 16/9/29.
 */
public class ListViewAdapter extends BaseAdapter {
    Tripday.NodesBean nodesBean;
    Context context;
    public ListViewAdapter(Context context, Tripday.NodesBean nodesBean){
        this.context=context;
        this.nodesBean=nodesBean;
    }
    @Override
    public int getCount() {
        return nodesBean.getNotes().size();
    }

    @Override
    public Object getItem(int i) {
        return nodesBean.getNotes().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            holder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.child_item,null);
            holder.description= (TextView) view.findViewById(R.id.description);
            holder.entry_name= (TextView) view.findViewById(R.id.entry_name);
            holder.url= (ImageView) view.findViewById(R.id.url);
            holder.imageView= (ImageView) view.findViewById(R.id.imageview);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        if (nodesBean.getNotes().get(i).getDescription().equals(null)
                ||nodesBean.getNotes().get(i).getDescription().equals("null")
                || TextUtils.isEmpty(nodesBean.getNotes().get(i).getDescription())){
            holder.description.setVisibility(View.GONE);
        }else {
            holder.description.setVisibility(View.VISIBLE);
            holder.description.setText(nodesBean.getNotes().get(i).getDescription());
        }
        if (nodesBean.getNotes().get(i).getPhoto().getUrl().equals(null)
                ||nodesBean.getNotes().get(i).getPhoto().getUrl().equals("null")
                || TextUtils.isEmpty(nodesBean.getNotes().get(i).getPhoto().getUrl())){
            holder.url.setVisibility(View.GONE);
        }else {
            holder.url.setVisibility(View.VISIBLE);
            ImageLoader.getInstance().displayImage
                    (nodesBean.getNotes().get(i).getPhoto().getUrl(),holder.url);
        }
        if (nodesBean.getEntry_name().equals(null)
                ||nodesBean.getEntry_name().equals("null")
                || TextUtils.isEmpty(nodesBean.getEntry_name())){
            holder.entry_name.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.GONE);
        }else {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.entry_name.setVisibility(View.VISIBLE);
            holder.entry_name.setText(nodesBean.getEntry_name());
        }
        return view;
    }
    class ViewHolder{
        TextView description,entry_name;
        ImageView url,imageView;
    }
}
