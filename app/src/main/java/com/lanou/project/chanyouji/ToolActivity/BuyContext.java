package com.lanou.project.chanyouji.ToolActivity;

import java.io.Serializable;

/**
 * Created by lanouhn on 16/9/26.
 */
public class BuyContext implements Serializable {


  private  String time;
  private   float money;
  private   String type;
  private   String coin;
  private   String xiang;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getXiang() {
        return xiang;
    }

    public void setXiang(String xiang) {
        this.xiang = xiang;
    }
}
