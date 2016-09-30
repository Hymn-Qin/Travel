package com.lanou.project.chanyouji.Raiders;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by lanouhn on 16/9/28.
 */
public class MyScrollView extends ScrollView {


    private ScrollViewListener scrollViewListener;
    private int scrollDistanceY;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                int newY = getScrollY();
                if (newY != scrollDistanceY){
                    scrollDistanceY = newY;
                    scrollViewListener.sendDistanceY(scrollDistanceY);
                    handler.sendMessageDelayed(handler.obtainMessage(), 5);
                }
            }
        }
    };
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY,
                                   int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {




        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
                0, 0, isTouchEvent);
    }

    public interface ScrollViewListener{
        void sendDistanceY(int distance);

    }

    public void setScrollViewListener(ScrollViewListener listener){
        scrollViewListener = listener;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_UP){
//            handler.sendEmptyMessageDelayed(1, 30);
//        }
//        scrollDistanceY = getScrollY();
//        scrollViewListener.sendDistanceY(scrollDistanceY);
//
//
//        return super.onTouchEvent(ev);
//    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        if (t == oldt){
            handler.sendEmptyMessageDelayed(1, 30);
        }
        scrollDistanceY = getScrollY();
        scrollViewListener.sendDistanceY(scrollDistanceY);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
