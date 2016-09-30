package com.lanou.project.chanyouji.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.lanou.project.chanyouji.R;


/**
 * Created by lanouhn on 16/9/27.
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener{
    View view;//底部布局
    int totaItemcount;//当前总的数量
    int lastVisibleItem;//最后一个可见的item;
    boolean isLoading;
    ILoadLisener iLoadLisener;
    public MyListView(Context context) {
        super(context);
        initView(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context){
        LayoutInflater inflater= LayoutInflater.from(context);
        view=inflater.inflate(R.layout.footer_layout,null);
        view.findViewById(R.id.load_layout).setVisibility(View.GONE);
        this.addFooterView(view);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
            if (totaItemcount==lastVisibleItem && i==SCROLL_STATE_IDLE){
                if (!isLoading){
                    isLoading=true;
                    view.findViewById(R.id.load_layout).
                            setVisibility(View.VISIBLE);
                    iLoadLisener.onLoad();
                }
            }
    }


    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
       this.lastVisibleItem=i+i1;
       this.totaItemcount=i2;
    }
    public void loadComplete(){
        isLoading=false;
        view.findViewById(R.id.load_layout).setVisibility(View.GONE);
    }
    public void setILoadLisener(ILoadLisener iLoadLisener){
        this.iLoadLisener=iLoadLisener;
    }
    //加载更多数据的回调接口
    public interface ILoadLisener{
        public void onLoad();
    }
}
