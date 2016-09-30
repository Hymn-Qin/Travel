package com.lanou.project.chanyouji.Class;

/**
 * Created by lanouhn on 16/9/27.
 */
public class Auteur {

    /**
     * id : 18696
     * name : Zoe孟孟
     * gender : 0
     * image : http://tva4.sinaimg.cn/crop.0.0.180.180.50/6c805989jw1e8qgp5bmzyj2050050aa8.jpg
     * favorites_count : 81
     * likes_count : 395
     * attraction_favorites_count : 0
     * poi_favorites_count : 0
     * friends_count : 18
     * fans_count : 204
     * trips_count : 13
     * plans_count : 0
     * current_user_friend : false
     * trips : [{"id":593596,"name":"濑户内海北半圈-历史、艺术与兔子","photos_count":476,"start_date":"2016-09-01","end_date":"2016-09-06","days":6,"level":4,"privacy":false,"views_count":10478,"comments_count":21,"likes_count":52,"source":"app","password":null,"front_cover_photo_url":"http://p.chanyouji.cn/593596/1473326677588p1as4hgsb01sm71i6o1pg7flh15an6d.jpg"}]
     */

    private int id;
    private String name;
    private int gender;
    private String image;
    private int favorites_count;
    private int likes_count;
    private int attraction_favorites_count;
    private int poi_favorites_count;
    private int friends_count;
    private int fans_count;
    private String trips_count;
    private int plans_count;
    private boolean current_user_friend;
    /**
     * id : 593596
     * name : 濑户内海北半圈-历史、艺术与兔子
     * photos_count : 476
     * start_date : 2016-09-01
     * end_date : 2016-09-06
     * days : 6
     * level : 4
     * privacy : false
     * views_count : 10478
     * comments_count : 21
     * likes_count : 52
     * source : app
     * password : null
     * front_cover_photo_url : http://p.chanyouji.cn/593596/1473326677588p1as4hgsb01sm71i6o1pg7flh15an6d.jpg
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getAttraction_favorites_count() {
        return attraction_favorites_count;
    }

    public void setAttraction_favorites_count(int attraction_favorites_count) {
        this.attraction_favorites_count = attraction_favorites_count;
    }

    public int getPoi_favorites_count() {
        return poi_favorites_count;
    }

    public void setPoi_favorites_count(int poi_favorites_count) {
        this.poi_favorites_count = poi_favorites_count;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public int getFans_count() {
        return fans_count;
    }

    public void setFans_count(int fans_count) {
        this.fans_count = fans_count;
    }

    public String getTrips_count() {
        return trips_count;
    }

    public void setTrips_count(String trips_count) {
        this.trips_count = trips_count;
    }

    public int getPlans_count() {
        return plans_count;
    }

    public void setPlans_count(int plans_count) {
        this.plans_count = plans_count;
    }

    public boolean isCurrent_user_friend() {
        return current_user_friend;
    }

    public void setCurrent_user_friend(boolean current_user_friend) {
        this.current_user_friend = current_user_friend;
    }



}



