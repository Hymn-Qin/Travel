package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityFeatures;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lanouhn on 16/9/21.
 */
public class CityFeaturesAdapter extends BaseAdapter {
    Context context;
    List<CityFeatures> cityFeaturesList;
    public CityFeaturesAdapter (Context context, List<CityFeatures> cityFeaturesList){
        this.context = context;
        this.cityFeaturesList = cityFeaturesList;

    }
    @Override
    public int getCount() {
        return cityFeaturesList != null ? cityFeaturesList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return cityFeaturesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityFeaturesViewHolder featuresViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_city_features_item,null);
            featuresViewHolder = new CityFeaturesViewHolder();
            featuresViewHolder.foodView = (TextView) convertView.findViewById(R.id.features_item_food);
            featuresViewHolder.foodsView = (TextView) convertView.findViewById(R.id.features_item_f);
            featuresViewHolder.imageView = (ImageView) convertView.findViewById(R.id.features_item_image);

            convertView.setTag(featuresViewHolder);
        }else {
            featuresViewHolder = (CityFeaturesViewHolder) convertView.getTag();
        }
        CityFeatures cityFeatures = cityFeaturesList.get(position);
        ImageView imageView1 = (ImageView) convertView.findViewById(R.id.feature_item_bj);
        imageView1.getBackground().setAlpha(60);
        featuresViewHolder.foodView.setText(cityFeatures.getName());
        featuresViewHolder.foodsView.setText(cityFeatures.getTitle());
        String imageUrl = cityFeatures.getImage_url();
        Picasso.with(context)
                .load(imageUrl)
                .resize(630,300)//加载图片大小
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(featuresViewHolder.imageView);
        return convertView;
    }

    class CityFeaturesViewHolder{

        TextView foodView, foodsView;
        ImageView imageView;
    }
}
