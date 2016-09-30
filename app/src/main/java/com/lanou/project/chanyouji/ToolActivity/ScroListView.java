package com.lanou.project.chanyouji.ToolActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by lanouhn on 16/9/26.
 */
public class ScroListView extends ListView {
    public ScroListView(Context context) {
        super(context);
    }

    public ScroListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScroListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
