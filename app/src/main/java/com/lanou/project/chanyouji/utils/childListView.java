package com.lanou.project.chanyouji.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by lanouhn on 16/9/29.
 */
public class childListView extends ListView {
    int height;

    public childListView(Context context) {
        super(context);
    }

    public childListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public childListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height= MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.UNSPECIFIED);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
