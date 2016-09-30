package com.lanou.project.chanyouji.Class;

/**
 * Created by lanouhn on 16/9/27.
 */
public class Photo {

    /**
     * id : 5649539
     * description : null
     * width : 1067
     * height : 1600
     * photo_url : http://p.chanyouji.cn/133744/1403101606405p18qnltuarspg1hr9147s1bm615fdc.jpg
     * trip_id : 133744
     */

    private int id;
    private Object description;
    private int width;
    private int height;
    private String photo_url;
    private int trip_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }
}
