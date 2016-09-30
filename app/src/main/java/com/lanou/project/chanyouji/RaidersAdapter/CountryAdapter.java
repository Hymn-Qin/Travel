package com.lanou.project.chanyouji.RaidersAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.Country;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by lanouhn on 16/9/14.
 */
public class CountryAdapter extends BaseAdapter {

    private Context context;
    private List<Country.DestinationsBean> destinationsBeanList;


    public CountryAdapter(Context context, List<Country.DestinationsBean> destinationsBeanList){
        this.context = context;
        this.destinationsBeanList = destinationsBeanList;

    }



    @Override
    public int getCount() {
        return destinationsBeanList != null ? destinationsBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {

        return destinationsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CountryView countryView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.country_item, null);
            countryView = new CountryView();
            countryView.imageView = (ImageView) convertView.findViewById(R.id.country_image);
            countryView.countryABC = (TextView) convertView.findViewById(R.id.country_abc);
            countryView.country = (TextView) convertView.findViewById(R.id.country_text);
            countryView.num = (TextView) convertView.findViewById(R.id.country_num);

            convertView.setTag(countryView);

        }else {
            countryView = (CountryView) convertView.getTag();
        }


        Country.DestinationsBean destinationsBean = destinationsBeanList.get(position);

        countryView.country.setText(destinationsBean.getName_zh_cn());
        countryView.countryABC.setText(destinationsBean.getName_en());
        countryView.num.setText( "   "+destinationsBean.getPoi_count() + "   ");
        String imageUrl = destinationsBean.getImage_url();
        Picasso.with(context)
                .load(imageUrl)
                .resize(230,300)//加载图片大小
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(countryView.imageView);


        return convertView;
    }

    class CountryView{
        ImageView imageView;
        TextView country, countryABC, num;

    }

}
