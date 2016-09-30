package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.lanou.project.chanyouji.Interface.OnViewItemClickListener;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityTravel;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lanouhn on 16/9/20.
 */
public class CityTravelListAdapter extends RecyclerView.Adapter<CityTravelListAdapter.CityTravelViewHolder> {

    Context context;
    List<CityTravel> cityTravelList;
    private OnViewItemClickListener onViewItemClickListener;
    public CityTravelListAdapter(Context context, List<CityTravel> cityTravelList){
        this.context = context;
        this.cityTravelList = cityTravelList;
    }

    public void setCityTravelList(List<CityTravel> cityTravelList) {
        this.cityTravelList = cityTravelList;
        notifyDataSetChanged();
    }

    @Override
    public CityTravelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_city_travel_item, null);
        CityTravelViewHolder viewHolder = new CityTravelViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityTravelViewHolder holder, final int position) {

        CityTravel cityTravel = cityTravelList.get(position);

        if (cityTravel.getUser_score() != null){
            holder.ratingBar.setRating(Float.parseFloat(cityTravel.getUser_score()));
        }

        holder.numTravel.setText(cityTravel.getAttraction_trips_count());
        holder.numTravel.getBackground().setAlpha(70);
        holder.addressTravel.setText(cityTravel.getName());
        holder.textTravel.setText(cityTravel.getDescription_summary());
        String imageUrl = cityTravel.getImage_url();
        Picasso.with(context)
                .load(imageUrl)
                .resize(200,250)//加载图片大小
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onViewItemClickListener != null){
                    onViewItemClickListener.OnItemClick(position);
                }
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return cityTravelList != null ? cityTravelList.size() : 0;
    }

    class CityTravelViewHolder extends RecyclerView.ViewHolder{
        TextView numTravel, addressTravel, textTravel;
        ImageView imageView;
        RatingBar ratingBar;

        public CityTravelViewHolder(View itemView) {
            super(itemView);
            ratingBar = (RatingBar) itemView.findViewById(R.id.city_travel_ratingBar_item);
            numTravel = (TextView) itemView.findViewById(R.id.city_travel_num_item);
            addressTravel = (TextView) itemView.findViewById(R.id.city_travel_address_item);
            textTravel = (TextView) itemView.findViewById(R.id.city_travel_text_item);
            imageView = (ImageView) itemView.findViewById(R.id.city_travel_image_item);
        }
    }

    public void setOnViewItemClickListener(OnViewItemClickListener onViewItemClickListener){
        this.onViewItemClickListener = onViewItemClickListener;
    }

}
