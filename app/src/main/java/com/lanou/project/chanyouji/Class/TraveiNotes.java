package com.lanou.project.chanyouji.Class;

import java.io.Serializable;

/**
 * Created by lanouhn on 16/9/22.
 */
public class TraveiNotes implements Serializable {

    /**
     * id : 593596
     * name : 濑户内海北半圈-历史、艺术与兔子
     * photos_count : 476
     * start_date : 2016-09-01
     * end_date : 2016-09-06
     * days : 6
     * level : 4
     * views_count : 2276
     * comments_count : 7
     * likes_count : 17
     * source : app
     * front_cover_photo_url : http://p.chanyouji.cn/593596/1473326677588p1as4hgsb01sm71i6o1pg7flh15an6d.jpg
     * featured : true
     * user : {"id":18696,"name":"Zoe孟孟","image":"http://tva4.sinaimg.cn/crop.0.0.180.180.50/6c805989jw1e8qgp5bmzyj2050050aa8.jpg"}
     */

    private String id;
    private String name;
    private String photos_count;
    private String start_date;
    private String end_date;
    private String days;
    private String level;
    private String views_count;
    private String comments_count;
    private String likes_count;
    private String source;
    private String front_cover_photo_url;
    private boolean featured;
    /**
     * id : 18696
     * name : Zoe孟孟
     * image : http://tva4.sinaimg.cn/crop.0.0.180.180.50/6c805989jw1e8qgp5bmzyj2050050aa8.jpg
     */

    private UserBean user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(String photos_count) {
        this.photos_count = photos_count;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getViews_count() {
        return views_count;
    }

    public void setViews_count(String views_count) {
        this.views_count = views_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFront_cover_photo_url() {
        return front_cover_photo_url;
    }

    public void setFront_cover_photo_url(String front_cover_photo_url) {
        this.front_cover_photo_url = front_cover_photo_url;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean implements Serializable {
        private String id;
        private String name;
        private String image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
