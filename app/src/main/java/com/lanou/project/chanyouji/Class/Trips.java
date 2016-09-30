package com.lanou.project.chanyouji.Class;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lanouhn on 16/9/27.
 */
public class Trips implements Parcelable {

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

    private int id;
    private String name;
    private int photos_count;
    private String start_date;
    private String end_date;
    private int days;
    private int level;
    private boolean privacy;
    private int views_count;
    private int comments_count;
    private int likes_count;
    private String source;
    private String front_cover_photo_url;

    protected Trips(Parcel in) {
        id = in.readInt();
        name = in.readString();
        photos_count = in.readInt();
        start_date = in.readString();
        end_date = in.readString();
        days = in.readInt();
        level = in.readInt();
        privacy = in.readByte() != 0;
        views_count = in.readInt();
        comments_count = in.readInt();
        likes_count = in.readInt();
        source = in.readString();
        front_cover_photo_url = in.readString();
    }

    public static final Creator<Trips> CREATOR = new Creator<Trips>() {
        @Override
        public Trips createFromParcel(Parcel in) {
            return new Trips(in);
        }

        @Override
        public Trips[] newArray(int size) {
            return new Trips[size];
        }
    };

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

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(photos_count);
        parcel.writeString(start_date);
        parcel.writeString(end_date);
        parcel.writeInt(days);
        parcel.writeInt(level);
        parcel.writeByte((byte) (privacy ? 1 : 0));
        parcel.writeInt(views_count);
        parcel.writeInt(comments_count);
        parcel.writeInt(likes_count);
        parcel.writeString(source);
        parcel.writeString(front_cover_photo_url);
    }
}
