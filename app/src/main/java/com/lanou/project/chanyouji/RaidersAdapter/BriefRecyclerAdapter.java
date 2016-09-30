package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CountryBrief;
import com.lanou.project.chanyouji.RaidersActivity.CityFeaturesActivity;
import com.lanou.project.chanyouji.RaidersActivity.CityRaidersActivity;
import com.lanou.project.chanyouji.RaidersActivity.CityRouteActivity;
import com.lanou.project.chanyouji.RaidersActivity.CityTravelActivity;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lanouhn on 16/9/18.
 */
public class BriefRecyclerAdapter extends RecyclerView.Adapter<BriefRecyclerAdapter.BriefViewHolder> {


    Context context;
    List<CountryBrief> briefList;
    public BriefRecyclerAdapter(Context context, List<CountryBrief> briefList){
        this.context = context;
        this.briefList = briefList;
    }
    @Override
    public BriefViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BriefViewHolder holder = null;
        View itemView = null;
        itemView = LayoutInflater.from(context).inflate(R.layout.item_country_brief, null);
        holder = new BriefViewHolder(itemView);
        return holder;

    }

    @Override
    public void onBindViewHolder(BriefViewHolder holder, int position) {
        final CountryBrief countryBrief = briefList.get(position);
        if (position == 0){
            holder.briefAddress.setText(countryBrief.getName_zh_cn() + "概览");
        }else {
            holder.briefAddress.setText(countryBrief.getName_zh_cn());
        }
        String imageUrl = countryBrief.getImage_url();
        holder.addressABC.setText(countryBrief.getName_en());

        Picasso.with(context)
                .load(imageUrl)
                .resize(630,380)//加载图片大小
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(holder.imageView);

        LinearLayout button01,button02,button03,button04;
        button01 = (LinearLayout) holder.itemView.findViewById(R.id.button1);
        button02 = (LinearLayout) holder.itemView.findViewById(R.id.button2);
        button03 = (LinearLayout) holder.itemView.findViewById(R.id.button3);
        button04 = (LinearLayout) holder.itemView.findViewById(R.id.button4);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //攻略
                Intent intent = new Intent(context, CityRaidersActivity.class);
                intent.putExtra("id",countryBrief.getId());
                intent.putExtra("city",countryBrief.getName_zh_cn());
                intent.putExtra("cityABC",countryBrief.getName_en());
                context.startActivity(intent);
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //路线
                Intent intent = new Intent(context, CityRouteActivity.class);
                intent.putExtra("id",countryBrief.getId());
                intent.putExtra("city",countryBrief.getName_zh_cn());
                intent.putExtra("cityABC",countryBrief.getName_en());
                context.startActivity(intent);
            }
        });
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //旅行地
                Intent intent = new Intent(context, CityTravelActivity.class);
                intent.putExtra("id",countryBrief.getId());
                intent.putExtra("city",countryBrief.getName_zh_cn());
                intent.putExtra("cityABC",countryBrief.getName_en());
                context.startActivity(intent);
            }
        });
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //专题
                Intent intent = new Intent(context, CityFeaturesActivity.class);
                intent.putExtra("id",countryBrief.getId());
                intent.putExtra("city",countryBrief.getName_zh_cn());
                intent.putExtra("cityABC",countryBrief.getName_en());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return briefList != null ? briefList.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class BriefViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView briefAddress, addressABC;

        public BriefViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.brief_image);
            briefAddress = (TextView) itemView.findViewById(R.id.brief_address);
            addressABC = (TextView) itemView.findViewById(R.id.address_ABC);

        }
    }
}
