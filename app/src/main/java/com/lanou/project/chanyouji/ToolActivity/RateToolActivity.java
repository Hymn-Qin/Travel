package com.lanou.project.chanyouji.ToolActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.project.chanyouji.R;

public class RateToolActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {


    private ImageView backScenicApot;
    private ImageView ivChanScenicSpot;
    private TextView tvTitleScenicSpot;
    private ImageView ivRateImage;
    private TextView tvZimu;
    private TextView tvRateMoney;

    private EditText china;
    private EditText usd;
    private EditText eur;
    private EditText random;

    private int id;

    private double rate;

    private int[] photo = {R.mipmap.china, R.mipmap.jp, R.mipmap.unitedkingdom, R.mipmap.unitedstates, R.mipmap.southkorea, R.mipmap.thailand, R.mipmap.malaysia
    , R.mipmap.singapore, R.mipmap.cambodia, R.mipmap.vietnam, R.mipmap.indonesia, R.mipmap.philippines, R.mipmap.srilanka, R.mipmap.nepal
    , R.mipmap.myanmar, R.mipmap.iran, R.mipmap.france, R.mipmap.italy, R.mipmap.germany, R.mipmap.switzerland, R.mipmap.spain, R.mipmap.austria, R.mipmap.turkey
    , R.mipmap.czechrepublic, R.mipmap.netherlands, R.mipmap.greece, R.mipmap.belgium, R.mipmap.hungary, R.mipmap.luxembourg, R.mipmap.ireland, R.mipmap.australia
    , R.mipmap.newzealand};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_tool);
        initView();
        initData();
        initEvent();
    }

    private void initView() {

        backScenicApot = (ImageView) findViewById(R.id.back_scenic_apot);
        ivChanScenicSpot = (ImageView) findViewById(R.id.iv_chan_scenic_spot);
        tvTitleScenicSpot = (TextView) findViewById(R.id.tv_title_scenic_spot);
        ivRateImage = (ImageView) findViewById(R.id.iv_rate_image);
        tvZimu = (TextView) findViewById(R.id.tv_zimu);
        tvRateMoney = (TextView) findViewById(R.id.tv_rate_money);


        china = (EditText) findViewById(R.id.et_rmb);
        usd = (EditText) findViewById(R.id.et_dollers);
        eur = (EditText) findViewById(R.id.et_yingbang);
        random = (EditText) findViewById(R.id.et_random);
    }

    private void initData() {

        Intent intent = getIntent();
        tvZimu.setText(intent.getStringExtra("currency_code"));
        tvRateMoney.setText(intent.getStringExtra("currency_display"));
        id = intent.getIntExtra("id", 0);
        switch (id) {
            case 45:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 114:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 115:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 116:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 187:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 226:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 227:
                ivRateImage.setImageResource(photo[5]);
                rate=0.19;
                break;
            case 47:
                ivRateImage.setImageResource(photo[4]);
                rate = 0.006;
                break;
            case 163:
                ivRateImage.setImageResource(photo[4]);
                rate = 0.006;
                break;
            case 164:
                ivRateImage.setImageResource(photo[4]);
                rate = 0.006;
                break;
            case 48:
                ivRateImage.setImageResource(photo[12]);
                rate = 0.045;
                break;
            case 421:
                ivRateImage.setImageResource(photo[12]);
                rate = 0.045;
                break;
            case 419:
                ivRateImage.setImageResource(photo[12]);
                rate = 0.045;
                break;
            case 420:
                ivRateImage.setImageResource(photo[12]);
                rate = 0.045;
                break;
            case 49:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 224:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 225:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 248:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 445:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 251:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 446:
                ivRateImage.setImageResource(photo[9]);
                rate=0.000299;
                break;
            case 50:
                ivRateImage.setImageResource(photo[14]);
                rate=0.005325;
                break;
            case 257:
                ivRateImage.setImageResource(photo[14]);
                rate=0.005325;
                break;
            case 255:
                ivRateImage.setImageResource(photo[14]);
                rate=0.005325;
                break;
            case 256:
                ivRateImage.setImageResource(photo[14]);
                rate=0.005325;
                break;
            case 258:
                ivRateImage.setImageResource(photo[14]);
                rate=0.005325;
                break;
            case 53:
                ivRateImage.setImageResource(photo[7]);
                rate=4.904;
                break;
            case 54:
                ivRateImage.setImageResource(photo[8]);
                rate=0.001647;
                break;
            case 117:
                ivRateImage.setImageResource(photo[8]);
                rate=0.001647;
                break;
            case 262:
                ivRateImage.setImageResource(photo[8]);
                rate=0.001647;
                break;

            case 55:
                ivRateImage.setImageResource(photo[1]);
                rate = 0.066;
                break;
            case 165:
                ivRateImage.setImageResource(photo[1]);
                rate = 0.066;
                break;
            case 167:
                ivRateImage.setImageResource(photo[1]);
                rate = 0.066;
                break;
            case 166:
                ivRateImage.setImageResource(photo[1]);
                rate = 0.066;
                break;
            case 373:
                ivRateImage.setImageResource(photo[1]);
                rate = 0.066;
                break;
            case 203:
                ivRateImage.setImageResource(photo[1]);
                rate = 0.066;
                break;
            case 56:
                ivRateImage.setImageResource(photo[13]);
                rate = 0.063;
                break;
            case 269:
                ivRateImage.setImageResource(photo[13]);
                rate = 0.063;
                break;
            case 270:
                ivRateImage.setImageResource(photo[13]);
                rate = 0.063;
                break;
            case 271:
                ivRateImage.setImageResource(photo[13]);
                rate = 0.063;
                break;
            case 57:
                ivRateImage.setImageResource(photo[3]);
                rate = 6.6725;
                break;
            case 129:
                ivRateImage.setImageResource(photo[3]);
                rate = 6.6725;
                break;
            case 131:
                ivRateImage.setImageResource(photo[3]);
                rate = 6.6725;
                break;
            case 134:
                ivRateImage.setImageResource(photo[3]);
                rate = 6.6725;
                break;
            case 61:
                ivRateImage.setImageResource(photo[30]);
                rate = 5.1126;
                break;
            case 123:
                ivRateImage.setImageResource(photo[30]);
                rate = 5.1126;
                break;
            case 124:
                ivRateImage.setImageResource(photo[30]);
                rate = 5.1126;
                break;
            case 125:
                ivRateImage.setImageResource(photo[30]);
                rate = 5.1126;
                break;
            case 439:
                ivRateImage.setImageResource(photo[30]);
                rate = 5.1126;
                break;
            case 62:
                ivRateImage.setImageResource(photo[16]);
                rate = 7.49;
                break;
            case 189:
                ivRateImage.setImageResource(photo[16]);
                rate = 7.49;
                break;
            case 290:
                ivRateImage.setImageResource(photo[16]);
                rate = 7.49;
                break;
            case 188:
                ivRateImage.setImageResource(photo[16]);
                rate = 7.49;
                break;
            case 63:
                ivRateImage.setImageResource(photo[18]);
                rate = 7.49;
                break;
            case 339:
                ivRateImage.setImageResource(photo[18]);
                rate = 7.49;
                break;
            case 335:
                ivRateImage.setImageResource(photo[18]);
                rate = 7.49;
                break;
            case 397:
                ivRateImage.setImageResource(photo[18]);
                rate = 7.49;
                break;
            case 172:
                ivRateImage.setImageResource(photo[18]);
                rate = 7.49;
                break;
            case 336:
                ivRateImage.setImageResource(photo[18]);
                rate = 7.49;
                break;
            case 66:
                ivRateImage.setImageResource(photo[28]);
                rate = 7.49;
                break;
            case 67:
                ivRateImage.setImageResource(photo[2]);
                rate = 8.6803;
                break;
            case 127:
                ivRateImage.setImageResource(photo[2]);
                rate = 8.6803;
                break;
            case 128:
                ivRateImage.setImageResource(photo[2]);
                rate = 8.6803;
                break;
            case 370:
                ivRateImage.setImageResource(photo[2]);
                rate = 8.6803;
                break;
            case 324:
                ivRateImage.setImageResource(photo[2]);
                rate = 8.6803;
                break;
            case 322:
                ivRateImage.setImageResource(photo[2]);
                rate = 8.6803;
                break;
            case 68:
                ivRateImage.setImageResource(photo[31]);
                rate = 4.8369;
                break;
            case 377:
                ivRateImage.setImageResource(photo[31]);
                rate = 4.8369;
                break;
            case 378:
                ivRateImage.setImageResource(photo[31]);
                rate = 4.8369;
                break;
            case 337:
                ivRateImage.setImageResource(photo[31]);
                rate = 4.8369;
                break;
            case 126:
                ivRateImage.setImageResource(photo[31]);
                rate = 4.8369;
                break;
            case 380:
                ivRateImage.setImageResource(photo[31]);
                rate = 4.8369;
                break;
            case 69:
                ivRateImage.setImageResource(photo[22]);
                rate = 2.238175;
                break;
            case 174:
                ivRateImage.setImageResource(photo[22]);
                rate = 2.238175;
                break;
            case 307:
                ivRateImage.setImageResource(photo[22]);
                rate = 2.238175;
                break;
            case 71:
                ivRateImage.setImageResource(photo[6]);
                rate=1.6132;
                break;
            case 118:
                ivRateImage.setImageResource(photo[6]);
                rate=1.6132;
                break;
            case 119:
                ivRateImage.setImageResource(photo[6]);
                rate=1.6132;
                break;
            case 234:
                ivRateImage.setImageResource(photo[6]);
                rate=1.6132;
                break;
            case 235:
                ivRateImage.setImageResource(photo[6]);
                rate=1.6132;
                break;
            case 236:
                ivRateImage.setImageResource(photo[6]);
                rate=1.6132;
                break;
            case 73:
                ivRateImage.setImageResource(photo[11]);
                rate=0.1382;
                break;
            case 121:
                ivRateImage.setImageResource(photo[11]);
                rate=0.1382;
                break;
            case 261:
                ivRateImage.setImageResource(photo[11]);
                rate=0.1382;
                break;
            case 259:
                ivRateImage.setImageResource(photo[11]);
                rate=0.1382;
                break;
            case 260:
                ivRateImage.setImageResource(photo[11]);
                rate=0.1382;
                break;
            case 74:
                ivRateImage.setImageResource(photo[29]);
                rate=7.49;
                break;
            case 425:
                ivRateImage.setImageResource(photo[29]);
                rate=7.49;
                break;
            case 424:
                ivRateImage.setImageResource(photo[29]);
                rate=7.49;
                break;
            case 76:
                ivRateImage.setImageResource(photo[10]);
                rate=0.1004;
                break;
            case 122:
                ivRateImage.setImageResource(photo[10]);
                rate=0.1004;
                break;
            case 265:
                ivRateImage.setImageResource(photo[10]);
                rate=0.1004;
                break;
            case 77:
                ivRateImage.setImageResource(photo[20]);
                rate=7.49;
                break;
            case 176:
                ivRateImage.setImageResource(photo[20]);
                rate=7.49;
                break;
            case 177:
                ivRateImage.setImageResource(photo[20]);
                rate=7.49;
                break;
            case 363:
                ivRateImage.setImageResource(photo[20]);
                rate=7.49;
                break;
            case 364:
                ivRateImage.setImageResource(photo[20]);
                rate=7.49;
                break;
            case 80 :
                ivRateImage.setImageResource(photo[17]);
                rate=7.49;
                break;
            case 178 :
                ivRateImage.setImageResource(photo[17]);
                rate=7.49;
                break;
            case 182 :
                ivRateImage.setImageResource(photo[17]);
                rate=7.49;
                break;
            case 185 :
                ivRateImage.setImageResource(photo[17]);
                rate=7.49;
                break;
            case 183 :
                ivRateImage.setImageResource(photo[17]);
                rate=7.49;
                break;
            case 308 :
                ivRateImage.setImageResource(photo[17]);
                rate=7.49;
                break;
            case 81:
                ivRateImage.setImageResource(photo[23]);
                rate=0.2772;
                break;
            case 197:
                ivRateImage.setImageResource(photo[23]);
                rate=0.2772;
                break;
            case 83:
                ivRateImage.setImageResource(photo[25]);
                rate=7.49;
                break;
            case 186:
                ivRateImage.setImageResource(photo[25]);
                rate=7.49;
                break;
            case 280:
                ivRateImage.setImageResource(photo[25]);
                rate=7.49;
                break;
            case 281:
                ivRateImage.setImageResource(photo[25]);
                rate=7.49;
                break;
            case 84:
                ivRateImage.setImageResource(photo[21]);
                rate=7.49;
                break;
            case 171:
                ivRateImage.setImageResource(photo[21]);
                rate=7.49;
                break;
            case 310:
                ivRateImage.setImageResource(photo[21]);
                rate=7.49;
                break;
            case 89:
                ivRateImage.setImageResource(photo[24]);
                rate=7.49;
                break;
            case 180:
                ivRateImage.setImageResource(photo[24]);
                rate=7.49;
                break;
            case 309:
                ivRateImage.setImageResource(photo[24]);
                rate=7.49;
                break;
            case 423:
                ivRateImage.setImageResource(photo[24]);
                rate=7.49;
                break;
            case 90:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;
            case 285:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;
            case 284:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;
            case 282:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;
            case 447:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;
            case 287:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;
            case 286:
                ivRateImage.setImageResource(photo[19]);
                rate=6.8791;
                break;


            case 97:
                ivRateImage.setImageResource(photo[27]);
                rate=7.49;
                break;
            case 191:
                ivRateImage.setImageResource(photo[27]);
                rate=7.49;
                break;
            case 99:
                ivRateImage.setImageResource(photo[26]);
                rate=7.49;
                break;
            case 181:
                ivRateImage.setImageResource(photo[26]);
                rate=7.49;
                break;
            case 206:
                ivRateImage.setImageResource(photo[3]);
                rate=7.49;
                break;
            case 133:
                ivRateImage.setImageResource(photo[3]);
                rate=7.49;
                break;
            case 132:
                ivRateImage.setImageResource(photo[3]);
                rate=7.49;
                break;
            case 211:
                ivRateImage.setImageResource(photo[15]);
                rate=0.022;
                break;
            case 432:
                ivRateImage.setImageResource(photo[15]);
                rate=0.022;
                break;
            case 433:
                ivRateImage.setImageResource(photo[15]);
                rate=0.022;
                break;
            case 434:
                ivRateImage.setImageResource(photo[15]);
                rate=0.022;
                break;


            default:
                ivRateImage.setImageResource(photo[0]);
                rate = 1;
                break;
        }

    }

    private void initEvent() {
        backScenicApot.setOnClickListener(this);
        ivChanScenicSpot.setOnClickListener(this);

        china.setOnFocusChangeListener(this);
        random.setOnFocusChangeListener(this);
        usd.setOnFocusChangeListener(this);
        eur.setOnFocusChangeListener(this);


        //人民币的点击事件
        china.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                random.setText("");
//                usd.setText("");
//                eur.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (!"".equals(china.getText().toString().trim())) {

                    float name = Float.valueOf(china.getText().toString().trim());
                    usd.setHint("" + name / 6.6);
                    eur.setHint("" + name / 8.8);
                    random.setHint("" + name / rate);
                    random.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    usd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    eur.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});


                }
            }

            @Override
            public void afterTextChanged(Editable s) {
//                if ("".equals(china.getText().toString().trim())) {
//                    random.setText(null);
//                    usd.setText(null);
//                    eur.setText(null);
//                }
            }
        });
        //美元的点击事件
        usd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                random.setText("");
//                china.setText("");
//                eur.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                if (!"".equals(usd.getText().toString().trim())) {

                    float name = Float.valueOf(usd.getText().toString().trim());
                    china.setHint("" + (int)name * 6.6);
                    eur.setHint("" + (int)name * 6.6/8.8);
                    random.setHint("" + (int)name *6.6/ rate);
                    random.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    china.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    eur.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
//                if ("".equals(usd.getText().toString().trim())) {
//                    random.setText(null);
//                    china.setText(null);
//                    eur.setText(null);
//                }
            }
        });
        //英镑的点击事件
        eur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                china.setText("");
//                usd.setText("");
//                random.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!"".equals(eur.getText().toString().trim())) {

                    float name = Float.valueOf(eur.getText().toString().trim());
                    china.setHint("" +(int) name * 8.8);
                    usd.setHint("" + (int)name *8.8/6.6);
                    random.setHint("" + (int)name*8.8 / rate);
                    random.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    china.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    usd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //一直改变的money的点击事件
        random.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                china.setText("");
//                usd.setText("");
//                eur.setText("");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!"".equals(random.getText().toString().trim())) {

                    float name = Float.valueOf(random.getText().toString().trim());

                    china.setHint("" + (int)name * rate);
                    eur.setHint("" + (int)name *rate/ 8.8);
                    usd.setHint("" + (int) name * rate/6.6);
                    usd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    china.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                    eur.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_scenic_apot:
            case R.id.iv_chan_scenic_spot:
                finish();
                break;

        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        EditText current = (EditText) v;
        if (!hasFocus) {
            current.setText("0");
            current.setText("");
        }
    }
}
