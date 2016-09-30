package com.lanou.project.chanyouji.Raiders;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;

/**
 * Created by lanouhn on 16/9/21.
 */
public class MyDialog extends Dialog{
    Context context ;


    public MyDialog(Context context) {
        super(context);
        this.context = context;
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);
    }

    public static   MyDialog creatDialog(Context context, String s){
        View view = LayoutInflater.from(context).inflate(R.layout.my_good_dialog, null);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.linear);


        TextView textView = (TextView) view.findViewById(R.id.tip);
        if (s == null){
            textView.setVisibility(View.GONE);
        }else {
            textView.setText(s);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

        MyDialog dialog = new MyDialog(context, R.style.myDialog);

        dialog.setTitle("");
        dialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        dialog.setCancelable(true);
//        dialog.setOnCancelListener(null);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.dimAmount = 0.7f;
        dialog.getWindow().setAttributes(layoutParams);


        return dialog;
    }


}
