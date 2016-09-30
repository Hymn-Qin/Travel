package com.lanou.project.chanyouji.RaidersActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.Raiders.CityRaiders;
import com.lanou.project.chanyouji.Raiders.MyDialog;
import com.lanou.project.chanyouji.Raiders.NoScrollGridView;
import com.lanou.project.chanyouji.utils.HttpUtils;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityRaidersItemListItemActivity extends AppCompatActivity {

    ListView listView;
    List<CityRaiders.PagesBean.ChildrenBean> childrenLists;
    List<CityRaiders.PagesBean.ChildrenBean.SectionsBean> sectionsList;
    List<CityRaiders>  cityRaidersList;
    String url1 = "http://chanyouji.com/api/wiki/destinations/";
    String url2 = ".json";
    String urlID = "";
    String urlPath = "";
    String titleItem = "";
    String ids;
    ExpandableListView exListView;
    Handler handler;
    TextView textView, cityTEXT, cityABCTEXT;
    LinearLayout backL;
    MyDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_raiders_item);

        dialog = MyDialog.creatDialog(this, "加载中...");
        dialog.show();

        exListView = (ExpandableListView) findViewById(R.id.city_raiders_item_list);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        exListView.setIndicatorBounds(displayMetrics.widthPixels-60,displayMetrics.widthPixels);
        Intent intent = getIntent();
        titleItem = intent.getStringExtra("titleItem");
        urlID = intent.getStringExtra("urlID");
        ids = intent.getStringExtra("ids");
        urlPath = url1 + urlID + url2;
        textView = (TextView) findViewById(R.id.brief_title);
        cityTEXT = (TextView) findViewById(R.id.country_item);
        backL = (LinearLayout) findViewById(R.id.back_back);
        textView.setText(titleItem);
        cityTEXT.setText(titleItem);
        URLPath();
        backL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200){
                    Map<String, List<CityRaiders.PagesBean.ChildrenBean>> map = new HashMap<>();
                    for (int i = 0; i < cityRaidersList.size(); i++) {
                        for (CityRaiders.PagesBean pages : cityRaidersList.get(i).getPages()){
                            String id = pages.getId();
                            List<CityRaiders.PagesBean.ChildrenBean> childrenList = pages.getChildren();
                            map.put(id, childrenList);
                            for (int l = 0; l < childrenList.size(); l++) {
                                id = childrenList.get(l).getId();
                                List<CityRaiders.PagesBean.ChildrenBean> childrenListss = new ArrayList<>();
                                childrenListss.add(0,childrenList.get(l));
                                map.put(id, childrenListss);

                            }

                        }


                    }
                    childrenLists = map.get(ids);
                    dialog.dismiss();
                    exListView.setAdapter(new MyAdapter(CityRaidersItemListItemActivity.this,childrenLists));


                }
                return false;
            }
        });


    }


    public void URLPath(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(urlPath, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        cityRaidersList = gson.fromJson(result,
                                new TypeToken<List<CityRaiders>>(){}.getType());
                        handler.sendEmptyMessage(200);
                    }
                });
            }
        }).start();
    }



    class MyAdapter extends BaseExpandableListAdapter{

        private Context context1;
        private List<CityRaiders.PagesBean.ChildrenBean> childrenList;
        private List<CityRaiders> cityRaidersList;
        private String urlPath;
        private Handler handler;
        public MyAdapter(Context context, List<CityRaiders.PagesBean.ChildrenBean> childrenList){

            this.context1 = context;
            this.childrenList = childrenList;
        }

        public void setNewChild(Context context, List<CityRaiders.PagesBean.ChildrenBean> childrenList){

            this.context1 = context;
            this.childrenList = childrenList;
            notifyDataSetChanged();
        }



        @Override
        public int getGroupCount() {
            return childrenList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childrenList.get(groupPosition).getSections().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return childrenList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childrenList.get(groupPosition).getSections().get(childPosition);
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

                convertView = LayoutInflater.from(context1).inflate(
                        R.layout.activity_city_raiders_item_groups, null);
            }

            TextView t = (TextView) convertView.findViewById(R.id.city_raiders_item_groups_text);

            t.setText(childrenList.get(groupPosition).getTitle());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ChildViewHolder holder = null;


            if (convertView == null){

                convertView = LayoutInflater.from(context1).inflate(R.layout.activity_city_raiders_item_childs, null);
                holder = new ChildViewHolder();
                holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.scro_image);
                holder.childText = (TextView) convertView.findViewById(R.id.child_text);
                holder.titleText = (TextView) convertView.findViewById(R.id.child_title);
                holder.author = (TextView) convertView.findViewById(R.id.author);
                holder.timer = (TextView) convertView.findViewById(R.id.child_time);
                holder.gridView = (NoScrollGridView) convertView.findViewById(R.id.child_Grid_list);
                holder.linearLayoutAddress = (LinearLayout) convertView.findViewById(R.id.addressNum1);
                holder.gridViewAddress = (NoScrollGridView) convertView.findViewById(R.id.address_name);
                holder.addressText = (TextView) convertView.findViewById(R.id.child_listView_address);
                holder.relativeLayout = (RelativeLayout) convertView.findViewById(R.id.child_xiangguan);
                convertView.setTag(holder);
            }else {
                holder = (ChildViewHolder) convertView.getTag();
            }

            List<CityRaiders.PagesBean.ChildrenBean.SectionsBean> sList = childrenList.get(groupPosition).getSections();
            //标题
            String title = sList.get(childPosition).getTitle();
            //text
            String description = sList.get(childPosition).getDescription();
            //time
            String travel_date = sList.get(childPosition).getTravel_date();
//            //地址集合
            List<CityRaiders.PagesBean.ChildrenBean.SectionsBean.AttractionsBean> attractions =
                    sList.get(childPosition).getAttractions();
//            //作者
            CityRaiders.PagesBean.ChildrenBean.SectionsBean.UserBean user = sList.get(childPosition).getUser();
            //相关内容ListView
            final List<CityRaiders.PagesBean.ChildrenBean.SectionsBean.PagesBeans> pagesList = sList.get(childPosition).getPages();
//            //viewPager
            List<CityRaiders.PagesBean.ChildrenBean.SectionsBean.PhotosBean> photosList = sList.get(childPosition).getPhotos();
            if (description != null){
                List<Integer> indexList = new ArrayList<>();
                for (int i = 0; i < description.length(); i++) {
                    if (description.charAt(i) == '#') {
                        indexList.add(i);
                    }
                }
                SpannableStringBuilder style=new SpannableStringBuilder(description);
                for (int i = 0; i < indexList.size(); i+=2) {
                    style.setSpan(new StyleSpan(Typeface.BOLD),indexList.get(i),indexList.get(i+1) + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                holder.childText.setText(style);
            }
            if (title != null){
                holder.titleText.setText(title);
            }
            if (pagesList != null && pagesList.size() != 0){
                holder.relativeLayout.setVisibility(View.VISIBLE);
                ChildListViewAdapter adapter = new ChildListViewAdapter(getBaseContext(), pagesList);
                holder.gridView.setAdapter(adapter);

                holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                    String urlID = pagesList.get(position).getDestination_id();
                    String ids = pagesList.get(position).getId();
                    String titleItem = pagesList.get(position).getTitle();
                    Intent intent = new Intent(getBaseContext(),CityRaidersItemListItemListItemActivity.class);
                    intent.putExtra("urlID",urlID);
                    intent.putExtra("ids", ids);
                    intent.putExtra("titleItem",titleItem);
                    startActivity(intent);

                }
            });
            }else {
                holder.relativeLayout.setVisibility(View.GONE);
            }
            if (user != null ){
                holder.author.setVisibility(View.VISIBLE);
                holder.author.setText(user.getName());
            }else {
                holder.author.setVisibility(View.GONE);
            }
            if (travel_date != null){
                holder.timer.setVisibility(View.VISIBLE);
                holder.timer.setText(travel_date);
            }else {
                holder.timer.setVisibility(View.GONE);
            }
//            //Grid
            if (attractions != null && attractions.size() != 0){
                if (attractions.size() == 1){

                    holder.linearLayoutAddress.setVisibility(View.VISIBLE);
                    holder.gridViewAddress.setVisibility(View.GONE);
                    holder.addressText.setText(attractions.get(0).getName());
                }else {
                    holder.linearLayoutAddress.setVisibility(View.GONE);
                    holder.gridViewAddress.setVisibility(View.VISIBLE);
                    AddressAdapter addressAdapter = new AddressAdapter(getBaseContext(), attractions);
                    holder.gridViewAddress.setAdapter(addressAdapter);
                }
            }else {
                holder.linearLayoutAddress.setVisibility(View.GONE);
                holder.gridViewAddress.setVisibility(View.GONE);
            }

            holder.linearLayout.removeAllViews();
            if (photosList != null && photosList.size() != 0){
                HorizontalScrollView scrollView = (HorizontalScrollView) convertView.findViewById(R.id.child_viewPager);
                scrollView.setVisibility(View.VISIBLE);
                for (CityRaiders.PagesBean.ChildrenBean.SectionsBean.PhotosBean photosBean : photosList){

                    String imageUrl = photosBean.getImage_url();
                    int w = photosBean.getImage_width();
                    int h = photosBean.getImage_height();
                    View view = LayoutInflater.from(context1).inflate(R.layout.activity_city_raiders_item_childs_list_image,null);
                    ImageView imageView = (ImageView) view.findViewById(R.id.child_image_view);
                    if ( h > 300){
                        w = w/ (h  / 300 ) + 20;
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w, 300);
                        imageView.setLayoutParams(params);
                    }else {
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w, h);
                        imageView.setLayoutParams(params);
                    }


                    Picasso.with(getApplicationContext())
                            .load(imageUrl)
                            .resize(400,400)//加载图片大小
                            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                            .into(imageView);
                    holder.linearLayout.addView(view);
                }
            }



            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }

        class ChildViewHolder{
            LinearLayout linearLayout, linearLayoutAddress;
            TextView childText, addressText;
            TextView titleText;
            TextView author;
            TextView timer;
            NoScrollGridView gridView, gridViewAddress;
            RelativeLayout relativeLayout;

        }
    }

    class ChildListViewAdapter extends BaseAdapter{

        Context context;
        List<CityRaiders.PagesBean.
                ChildrenBean.SectionsBean.PagesBeans> pagesBeansList;
        public ChildListViewAdapter (Context context,
                                     List<CityRaiders.PagesBean.
                                             ChildrenBean.SectionsBean.PagesBeans> pagesBeansList){

            this.context = context;
            this.pagesBeansList = pagesBeansList;
        }

        @Override
        public int getCount() {
            return pagesBeansList != null ? pagesBeansList.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return pagesBeansList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListViewHolder holder = null;
            if (convertView == null){
                convertView = LayoutInflater.from(getBaseContext()).inflate(
                        R.layout.activity_city_raiders_item_childs_list_view, null);
                holder = new ListViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.child_listView_title);
                convertView.setTag(holder);


            }else {
                holder = (ListViewHolder) convertView.getTag();
            }

            CityRaiders.PagesBean.ChildrenBean.SectionsBean.PagesBeans pagesBeans = pagesBeansList.get(position);

            holder.textView.setText(pagesBeans.getTitle());



            return convertView;
        }
        class ListViewHolder{
            TextView textView;
        }
    }

    class AddressAdapter extends BaseAdapter{

        Context context;
        List<CityRaiders.PagesBean.ChildrenBean.SectionsBean.AttractionsBean> attractionsBeanList;
        public AddressAdapter(Context context, List<CityRaiders.
                PagesBean.ChildrenBean.SectionsBean.AttractionsBean> attractionsBeanList){

            this.context = context;
            this.attractionsBeanList = attractionsBeanList;
        }
        @Override
        public int getCount() {
            return attractionsBeanList != null ? attractionsBeanList.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return attractionsBeanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            AddressHolder holder = null;
//            if (convertView != null){
                convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_city_raiders_item_childs_address, null);
                holder = new AddressHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.child_listView_address);

//                convertView.setTag(holder);
//            }else{
//                holder = (AddressHolder) convertView.getTag();
//            }
            CityRaiders.PagesBean.ChildrenBean.SectionsBean.AttractionsBean attractionsBean = attractionsBeanList.get(position);
            holder.textView.setText(attractionsBean.getName());


            return convertView;
        }

        class AddressHolder{
            TextView textView;
        }
    }

}

