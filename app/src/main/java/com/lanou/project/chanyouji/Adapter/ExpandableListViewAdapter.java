package com.lanou.project.chanyouji.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.lanou.project.chanyouji.Class.Tripday;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.ListViewParamsUtils;
import com.lanou.project.chanyouji.utils.childListView;

import java.util.List;


/**
 * Created by lanouhn on 16/9/29.
 */
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    List<Tripday> tripdayList;
    Context context;
    public ExpandableListViewAdapter(Context context, List<Tripday> tripdayList){
        this.context=context;
        this.tripdayList=tripdayList;
    }
    @Override
    public int getGroupCount() {
        return tripdayList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return tripdayList.get(i).getNodes().size();
    }

    @Override
    public Object getGroup(int i) {
        return tripdayList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return tripdayList.get(i).getNodes().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.day_layout,null);
        TextView textView= (TextView) view.findViewById(R.id.textview);
        textView.setText(tripdayList.get(i).getTrip_date());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder holder=null;
        if (view==null){
            holder=new ChildHolder();
            view= LayoutInflater.from(context).inflate(R.layout.parent_item,null);
            holder.entry_name= (TextView) view.findViewById(R.id.entry_name);
            holder.comment= (TextView) view.findViewById(R.id.comment);
            holder.listView= (childListView) view.findViewById(R.id.listview);
            view.setTag(holder);
        }else {
            holder= (ChildHolder) view.getTag();
        }
        if (tripdayList.get(i).getNodes().get(i1).getEntry_name().equals(null)
                ||tripdayList.get(i).getNodes().get(i1).getEntry_name().equals("null")
                || TextUtils.isEmpty(tripdayList.get(i).getNodes().get(i1).getEntry_name())){
            holder.entry_name.setVisibility(View.GONE);
        }else {
            holder.entry_name.setVisibility(View.VISIBLE);
            holder.entry_name.setText(tripdayList.get(i).getNodes().get(i1).getEntry_name());
        }
        if (tripdayList.get(i).getNodes().get(i1).getComment().equals(null)
                ||tripdayList.get(i).getNodes().get(i1).getComment().equals("null")
                || TextUtils.isEmpty(tripdayList.get(i).getNodes().get(i1).getComment())){
            holder.comment.setVisibility(View.GONE);
        }else {
            holder.comment.setVisibility(View.VISIBLE);
            holder.comment.setText(tripdayList.get(i).getNodes().get(i1).getComment());
        }
        ListViewAdapter adapter=new ListViewAdapter
                (context,tripdayList.get(i).getNodes().get(i1));
        holder.listView.setAdapter(adapter);
        ListViewParamsUtils.setListViewHeightBasedOnChildren(holder.listView);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    class ChildHolder{
        TextView entry_name,comment;
        childListView listView;
    }
}
