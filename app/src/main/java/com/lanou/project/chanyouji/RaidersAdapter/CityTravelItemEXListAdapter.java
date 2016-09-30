package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityTravelItem;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanouhn on 16/9/29.
 */
public class CityTravelItemEXListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<CityTravelItem.AttractionTripTagsBean> attractionTripTagsBeanList;
    public CityTravelItemEXListAdapter (Context context, List<CityTravelItem.AttractionTripTagsBean> attractionTripTagsBeanList){
        this.context = context;
        this.attractionTripTagsBeanList = attractionTripTagsBeanList;
    }
    @Override
    public int getGroupCount() {
        return attractionTripTagsBeanList != null ? attractionTripTagsBeanList.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return attractionTripTagsBeanList.get(groupPosition).getAttraction_contents() != null ?
                attractionTripTagsBeanList.get(groupPosition).getAttraction_contents().size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return attractionTripTagsBeanList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return attractionTripTagsBeanList.get(groupPosition).getAttraction_contents().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_city_travel_list_item_list_group, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.travel_item_group);
        textView.setText(attractionTripTagsBeanList.get(groupPosition).getName());


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_city_travel_list_item_list_child, null);
            holder = new ChildViewHolder();
            holder.titleText = (TextView) convertView.findViewById(R.id.travel_item_child_title);
            holder.authorText = (TextView) convertView.findViewById(R.id.travel_item_child_author);
            holder.timeText = (TextView) convertView.findViewById(R.id.travel_item_child_time);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.travel_item_child_LY_HSV);
            convertView.setTag(holder);
        }else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        List<CityTravelItem.AttractionTripTagsBean.AttractionContentsBean> attractionContentsBeanList =
                attractionTripTagsBeanList.get(groupPosition).getAttraction_contents();
        CityTravelItem.AttractionTripTagsBean.AttractionContentsBean attractionContentsBean =
                attractionContentsBeanList.get(childPosition);
        String title = attractionContentsBean.getDescription();
        String author = "@" + attractionContentsBean.getTrip().getUser().getName();
        String timer = attractionContentsBean.getTrip().getStart_date();
        List<CityTravelItem.AttractionTripTagsBean.AttractionContentsBean.NotesBean> notesBeanList =
                attractionContentsBean.getNotes();



            List<Integer> indexList = new ArrayList<>();
            for (int i = 0; i < title.length(); i++) {
                if (title.charAt(i) == '#') {
                    indexList.add(i);
                }
            }
            SpannableStringBuilder style=new SpannableStringBuilder(title);
            for (int i = 0; i < indexList.size(); i+=2) {
                style.setSpan(new StyleSpan(Typeface.BOLD),indexList.get(i),indexList.get(i+1) + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        holder.titleText.setText(style);
        holder.authorText.setText(author);
        holder.timeText.setText(timer);


        holder.linearLayout.removeAllViews();
        for (CityTravelItem.AttractionTripTagsBean.AttractionContentsBean.NotesBean notesBean : notesBeanList) {

            String imageUrl = notesBean.getPhoto_url();
            String biaoqian = notesBean.getDescription();
            int w = notesBean.getWidth();
            int h = notesBean.getHeight();
            View view = LayoutInflater.from(context).inflate(R.layout.activity_city_travel_list_item_childs_ex_list_image, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.travel_item_child_image_view);
            TextView textView = (TextView) view.findViewById(R.id.travel_item_child_image_text);

            if (h > 250) {
                w = w / (h / 250);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w > 400 ? 400 : w, 250);
                imageView.setLayoutParams(params);
            } else {
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w > 400 ? 400 : w, h);
                imageView.setLayoutParams(params);
            }


            textView.setText(biaoqian);
            textView.setMaxWidth(w > 400 ? 400 : w);
            Picasso.with(context)
                    .load(imageUrl)
                    .resize(630, 300)//加载图片大小
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .into(imageView);
            holder.linearLayout.addView(view);
        }





        return convertView;
    }
    class ChildViewHolder{
        TextView titleText, authorText, timeText;
        LinearLayout linearLayout;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
