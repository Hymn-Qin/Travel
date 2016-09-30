package com.lanou.project.chanyouji.utils;

/**
 * Created by lanouhn on 16/9/23.
 */
public class Day {


    /**
     * temp_min : 17
     * temp_max : 31
     * current_time : 10:57，周五
     * urls_category_0 : false
     * urls_category_1 : false
     * language_code : zh
     * currency_code : CNY
     * currency_display : 元
     * country_name : beijing
     */

    private int temp_min;
    private int temp_max;
    private String current_time;
    private String language_code;
    private String currency_code;
    private String currency_display;
    private String country_name;

    public int getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_display() {
        return currency_display;
    }

    public void setCurrency_display(String currency_display) {
        this.currency_display = currency_display;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
