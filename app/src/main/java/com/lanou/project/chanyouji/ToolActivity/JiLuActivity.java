package com.lanou.project.chanyouji.ToolActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.base.BuyAdapter;

import java.util.ArrayList;
import java.util.List;

public class JiLuActivity extends AppCompatActivity implements View.OnClickListener{

    private SQLiteDatabase db;
    ImageView imageView1,imageView2,imageView3;
    TextView textView,tvNotes,tvMoney;
    ListView listView;
    private  float sumMoney;
    View view;
    BuyContext by=new BuyContext();
    List<BuyContext> byList=new ArrayList<>();

    BuyAdapter byAdapter=new BuyAdapter(this,byList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_lu);

        initView();
        initEvent();
        listView.setAdapter(byAdapter);
    }

public void setDatabase(SQLiteDatabase db){
    if (db!=null){
        this.db=db;
    }
}
    private void initEvent() {
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        textView.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    private void initView() {
        imageView1= (ImageView) findViewById(R.id.back_image1);
        imageView2= (ImageView) findViewById(R.id.chan_image1);
        imageView3= (ImageView) findViewById(R.id.tool_travel);
        textView= (TextView) findViewById(R.id.title_text1);
        listView= (ListView) findViewById(R.id.buy_listView);
        tvNotes= (TextView) findViewById(R.id.tv_custon_notes);
        tvMoney= (TextView) findViewById(R.id.tv_money);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_image1:
            case R.id.chan_image1:
            case R.id.title_text1:
                finish();
                break;
            case R.id.tool_travel:
                Intent intent=new Intent(JiLuActivity.this,AddBuyActivity.class);
                startActivityForResult(intent,0);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==0){
            if (resultCode==RESULT_OK){

               tvNotes.setVisibility(View.GONE);
             by= (BuyContext) data.getSerializableExtra("buy");
                Log.d("JiLuActivity","fffffff"+ by.getCoin());
                Log.d("JiLuActivity", by.getTime());
                Log.d("JiLuActivity", String.valueOf(by.getMoney()));
                Log.d("JiLuActivity", by.getXiang());
                Log.d("JiLuActivity", by.getType());
                sumMoney+=by.getMoney();
                tvMoney.setText("共 "+sumMoney);

             byList.add(by);
                byAdapter.setChangeBuyAdapter(this,byList);

            }
        }
    }
}
