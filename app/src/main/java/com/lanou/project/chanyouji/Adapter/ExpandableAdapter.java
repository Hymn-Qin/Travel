package com.lanou.project.chanyouji.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.Class.Node;
import com.lanou.project.chanyouji.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by lanouhn on 16/9/28.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    List<Node> nodeList;
    Context context;

    public ExpandableAdapter(Context context, List<Node> nodeList) {
        this.context = context;
        this.nodeList = nodeList;
    }

    @Override
    public int getGroupCount() {
        return nodeList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return nodeList.get(i).getNotes().size();
    }

    @Override
    public Object getGroup(int i) {
        return nodeList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return nodeList.get(i).getNotes().get(i1);
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
        ViewHanlder hanlder = null;
        if (view == null) {
            hanlder = new ViewHanlder();
            view = LayoutInflater.from(context).
                    inflate(R.layout.parent_item_group, null);
            hanlder.comment = (TextView) view.findViewById(R.id.comment);
            hanlder.entry_name = (TextView) view.findViewById(R.id.entry_name);
            view.setTag(hanlder);
        } else {
            hanlder = (ViewHanlder) view.getTag();
        }
        if (TextUtils.isEmpty(nodeList.get(i).getEntry_name())
                ||nodeList.get(i).getEntry_name().equals(null)
                ||nodeList.get(i).getEntry_name().equals("null")){
            view.setVisibility(View.GONE);
            view.findViewById(R.id.CircleImageView).setVisibility(View.GONE);
        }else {
            view.setVisibility(View.VISIBLE);
            view.findViewById(R.id.CircleImageView).setVisibility(View.VISIBLE);
            hanlder.entry_name.setText(nodeList.get(i).getEntry_name());

        }
        if (TextUtils.isEmpty(nodeList.get(i).getComment())
                || nodeList.get(i).getComment().equals(null)
                || nodeList.get(i).getComment().equals("null")) {
            hanlder.comment.setVisibility(View.GONE);
        }else {
            hanlder.comment.setVisibility(View.VISIBLE);
            hanlder.comment.setText(nodeList.get(i).getComment());
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        MyViewHanlder hanlder = null;
        if (view == null) {
            hanlder = new MyViewHanlder();
            view = LayoutInflater.from(context).inflate
                    (R.layout.child_item, viewGroup, false);
            hanlder.url = (ImageView) view.findViewById(R.id.url);
            hanlder.description = (TextView) view.findViewById(R.id.description);
            hanlder.entry_name = (TextView) view.findViewById(R.id.entry_name);
            view.setTag(hanlder);
        } else {
            hanlder = (MyViewHanlder) view.getTag();
        }


        // 图片显示
        if (TextUtils.isEmpty(nodeList.get(i).getNotes().get(i1).getPhoto().getUrl())) {
            hanlder.url.setVisibility(View.GONE);
        } else {
            hanlder.url.setVisibility(View.VISIBLE);
            ImageLoader.getInstance().displayImage(nodeList.get(i).
                    getNotes().get(i1).getPhoto().getUrl(), hanlder.url);
        }
        if (TextUtils.isEmpty(nodeList.get(i).getNotes().get(i1).getDescription())
                ||nodeList.get(i).getNotes().get(i1).getDescription().equals(null)
                ||nodeList.get(i).getNotes().get(i1).getDescription().equals("null")) {
            hanlder.description.setVisibility(View.GONE);
        } else {
            hanlder.description.setVisibility(View.VISIBLE);
            hanlder.description.setText
                    (nodeList.get(i).getNotes().get(i1).getDescription());
        }
        if (nodeList.get(i).getEntry_name().equals(null)
                ||nodeList.get(i).getEntry_name().equals("null")
                || TextUtils.isEmpty(nodeList.get(i).getEntry_name())){
            hanlder.entry_name.setVisibility(View.INVISIBLE);
            view.findViewById(R.id.imageview).setVisibility(View.INVISIBLE);

        }else {
            view.findViewById(R.id.imageview).setVisibility(View.VISIBLE);
            hanlder.entry_name.setVisibility(View.VISIBLE);
            hanlder.entry_name.setText(nodeList.get(i).getEntry_name());
        }
        if ((TextUtils.isEmpty(nodeList.get(i).getNotes().get(i1).getDescription())
                ||nodeList.get(i).getNotes().get(i1).getDescription().equals(null)
                ||nodeList.get(i).getNotes().get(i1).getDescription().equals("null"))
                &&(TextUtils.isEmpty(nodeList.get(i).getNotes().get(i1).getPhoto().getUrl()))){
            view.findViewById(R.id.ll).setVisibility(View.GONE);
        }else {
            view.findViewById(R.id.ll).setVisibility(View.VISIBLE);
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class ViewHanlder {
        TextView entry_name, comment;

    }

    class MyViewHanlder {
        ImageView url;
        TextView description, entry_name;

    }
}
