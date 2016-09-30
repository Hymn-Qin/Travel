package com.lanou.project.chanyouji.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.Class.TraveiNotes;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.TraveNotesActivity.WriterActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



/**
 * Created by lanouhn on 16/9/22.
 */
public class TravelNotesAdapter extends BaseAdapter {
    List<TraveiNotes> traveiNotesList;
    Context context;
    public TravelNotesAdapter(Context context, List<TraveiNotes> traveiNotesList){
        this.context=context;
        this.traveiNotesList=traveiNotesList;
    }
    @Override
    public int getCount() {
        return traveiNotesList!=null?traveiNotesList.size():0;
    }

    @Override
    public Object getItem(int i) {
        return traveiNotesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Myviewholder holder=null;
        if (view==null){
            holder=new Myviewholder();
            view= LayoutInflater.from(context).inflate(R.layout.tna_item,null);
            holder.front_cover_photo_url= (ImageView) view.findViewById(R.id.front_cover_photo_url);
            holder.image= (CircleImageView) view.findViewById(R.id.image);
            holder.days= (TextView) view.findViewById(R.id.days);
            holder.name= (TextView) view.findViewById(R.id.name);
            holder.photos_count= (TextView) view.findViewById(R.id.photos_count);
            holder.start_date= (TextView) view.findViewById(R.id.start_date);
            view.setTag(holder);
        }else {
            holder= (Myviewholder) view.getTag();
        }
        holder.name.setText(traveiNotesList.get(i).getName());
        holder.photos_count.setText(traveiNotesList.get(i).getPhotos_count()+"图");
        holder.start_date.setText(traveiNotesList.get(i).getStart_date()+"/");
        holder.days.setText(traveiNotesList.get(i).getDays()+"天");
        holder.front_cover_photo_url.setTag(traveiNotesList.get(i).
                getFront_cover_photo_url());
        ImageLoader.getInstance().displayImage(traveiNotesList.get(i).
                getFront_cover_photo_url(),holder.front_cover_photo_url);
        ImageLoader.getInstance().displayImage(traveiNotesList.
                get(i).getUser().getImage(),holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, WriterActivity.class);
                intent.putExtra("id",traveiNotesList.get(i).getUser().getId());
                context.startActivity(intent);
            }
        });
        return view;
    }
    class Myviewholder{
         ImageView front_cover_photo_url;
         CircleImageView image;
         TextView name,photos_count,start_date,days;
    }
}
