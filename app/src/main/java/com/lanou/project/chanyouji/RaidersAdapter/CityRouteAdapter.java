package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityRoute;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lanouhn on 16/9/19.
 */
public class CityRouteAdapter extends RecyclerView.Adapter<CityRouteAdapter.CityRouteViewHolder>{

    Context context;

    List<CityRoute> cityRouteList;
    public CityRouteAdapter(Context context, List<CityRoute> cityRouteList){
        this.context = context;
        this.cityRouteList = cityRouteList;
        Log.d("CityRouteAdapter", "cityRouteList.size():在这里" + cityRouteList.size());
    }

    @Override
    public CityRouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CityRouteViewHolder holder = null;
        View itemView = null;
        itemView = LayoutInflater.from(context).inflate(R.layout.city_route_recycler_item, null);



        holder = new CityRouteViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(CityRouteViewHolder holder, int position) {
        CityRoute cityRoute = cityRouteList.get(position);
        holder.routeText.setText(cityRoute.getDescription());
        holder.routeTime.setText(cityRoute.getPlan_days_count());
        holder.routeName.setText(cityRoute.getName());
        holder.routeNum.setText(cityRoute.getPlan_nodes_count());
        String imageUrl = cityRoute.getImage_url();
        Picasso.with(context)
                .load(imageUrl)
                .resize(630,380)//加载图片大小
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return cityRouteList != null ? cityRouteList.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class CityRouteViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView routeName, routeNum, routeTime, routeText;
        public CityRouteViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.route_image);
            routeName = (TextView) itemView.findViewById(R.id.route_name);
            routeNum = (TextView) itemView.findViewById(R.id.num_route);
            routeTime = (TextView) itemView.findViewById(R.id.route_time);
            routeText = (TextView) itemView.findViewById(R.id.route_text);


        }
    }
}
