package com.lanou.project.chanyouji.ToolActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;
import com.lanou.project.chanyouji.utils.DBUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AddBuyActivity extends AppCompatActivity implements View.OnClickListener{


    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_dadpter;
    BuyContext by=new BuyContext();

    ImageView imageView1,imageView2,imageView3;
    TextView textView;
    private ImageView addEither;
    private  ImageView addTraffic;
    private ImageView addFood;
    private ImageView addHotel;
    private ImageView addTicket;
    private ImageView addShopping;
    private ImageView addEntertainment;
    private EditText etMoney;
    private EditText etDetail;
    private ImageView addTraver;

     private float  money;
    private  String detail;


    private String type = "其他";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_buy);
        spinner= (Spinner) findViewById(R.id.add_money);

        data_list=new ArrayList<String>();
        data_list.add("日元");
        data_list.add("人民币");
        data_list.add("美元");
        data_list.add("欧元");

        arr_dadpter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data_list);
        arr_dadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arr_dadpter);


        initView();
        initEvent();


    }



    private void initView() {
        imageView1= (ImageView) findViewById(R.id.back_image2);
        imageView2= (ImageView) findViewById(R.id.chan_image2);
        imageView3= (ImageView) findViewById(R.id.tool_travel);
        textView= (TextView) findViewById(R.id.title_text2);
        addEither= (ImageView) findViewById(R.id.add_either);
        addTraffic= (ImageView) findViewById(R.id.add_traffic);
        addFood= (ImageView) findViewById(R.id.add_food);
        addHotel= (ImageView) findViewById(R.id.add_hotel);
        addTicket= (ImageView) findViewById(R.id.add_ticket);
        addShopping= (ImageView) findViewById(R.id.add_shopping);
        addEntertainment= (ImageView) findViewById(R.id.add_entertainment);
        addTraver= (ImageView) findViewById(R.id.tool_travel);
        etMoney= (EditText) findViewById(R.id.et_money);
        etDetail= (EditText) findViewById(R.id.et_detail);

    }

    private void initEvent() {
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
         textView.setOnClickListener(this);
        addEither.setOnClickListener(this);
        addTraffic.setOnClickListener(this);
        addFood.setOnClickListener(this);
        addHotel.setOnClickListener(this);
        addTicket.setOnClickListener(this);
        addShopping.setOnClickListener(this);
        addEntertainment.setOnClickListener(this);
        etMoney.setOnClickListener(this);
        etDetail.setOnClickListener(this);
        addTraver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formatter=new SimpleDateFormat("MM月dd日");
                Date curDate=new Date(System.currentTimeMillis());
                String str=formatter.format(curDate);
                Intent intent=new Intent();
                Bundle bundle=new Bundle();

                if (etMoney!=null){
                    money= Float.parseFloat(etMoney.getText().toString());
                    by.setMoney(money);
                }else {
                    money= Float.parseFloat("");
                }

                if (etDetail!=null){
                    detail=etDetail.getText().toString();
                    by.setXiang(detail);
                }else {
                   detail="";
                }

                by.setType(type.toString());
                by.setTime(str);
                DBUtils.insertData(getApplicationContext(), String.valueOf(money),type,by.getCoin(),str,detail);
                bundle.putSerializable("buy",by);
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);

                finish();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                by.setCoin(data_list.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_image2:
            case R.id.chan_image2:
            case R.id.title_text2:
                finish();
                break;
            case R.id.add_either:
                type = "其他";
                addEither.setSelected(false);
                addTraffic.setSelected(false);
                addShopping.setSelected(false);
                addFood.setSelected(false);
                addTicket.setSelected(false);
                addHotel.setSelected(false);
                addEntertainment.setSelected(false);
                break;
            case R.id.add_traffic:
                type = "交通";
                addEither.setSelected(true);
                addTraffic.setSelected(true);
                addShopping.setSelected(false);
                addFood.setSelected(false);
                addTicket.setSelected(false);
                addHotel.setSelected(false);
                addEntertainment.setSelected(false);
                break;
            case R.id.add_food:
                type = "餐饮";
                addEither.setSelected(true);
                addTraffic.setSelected(false);
                addShopping.setSelected(false);
                addFood.setSelected(true);
                addTicket.setSelected(false);
                addHotel.setSelected(false);
                addEntertainment.setSelected(false);
                break;
            case R.id.add_hotel:
                type = "住宿";
                addEither.setSelected(true);
                addTraffic.setSelected(false);
                addShopping.setSelected(false);
                addFood.setSelected(false);
                addTicket.setSelected(false);
                addHotel.setSelected(true);
                addEntertainment.setSelected(false);

                break;
            case R.id.add_ticket:
                type = "门票";
                addEither.setSelected(true);
                addTraffic.setSelected(false);
                addShopping.setSelected(false);
                addFood.setSelected(false);
                addTicket.setSelected(true);
                addHotel.setSelected(false);
                addEntertainment.setSelected(false);

                break;
            case R.id.add_shopping:
                type = "购物";
                addEither.setSelected(true);
                addTraffic.setSelected(false);
                addShopping.setSelected(true);
                addFood.setSelected(false);
                addTicket.setSelected(false);
                addHotel.setSelected(false);
                addEntertainment.setSelected(false);
                break;
            case R.id.add_entertainment:
                type = "娱乐";

                addEither.setSelected(true);
                addTraffic.setSelected(false);
                addShopping.setSelected(false);
                addFood.setSelected(false);
                addTicket.setSelected(false);
                addHotel.setSelected(false);
                addEntertainment.setSelected(true);
                break;

        }
    }
}

