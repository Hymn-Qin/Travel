package com.lanou.project.chanyouji.Raiders;

/**
 * Created by lanouhn on 16/9/19.
 */
public class CityRoute {

    /**
     * id : 52
     * name : 曼谷+普吉+皮皮岛经典6日游
     * budget : 0
     * start_date : null
     * description : 2天曼谷+2天普吉+2天皮皮岛，曼谷的美食购物，普吉的沙滩阳光，皮皮岛的浮潜，这一切会让你轻松爱上泰国这个美好国度！
     * plan_days_count : 6
     * plan_nodes_count : 33
     * user_name :
     * image_url : http://m.chanyouji.cn/plans/52.jpg
     * updated_at : 1407732431
     */

    private int id;
    private String name;
    private int budget;
    private Object start_date;
    private String description;
    private String plan_days_count;
    private String plan_nodes_count;
    private String user_name;
    private String image_url;
    private int updated_at;

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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Object getStart_date() {
        return start_date;
    }

    public void setStart_date(Object start_date) {
        this.start_date = start_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlan_days_count() {
        return plan_days_count;
    }

    public void setPlan_days_count(String plan_days_count) {
        this.plan_days_count = plan_days_count;
    }

    public String getPlan_nodes_count() {
        return plan_nodes_count;
    }

    public void setPlan_nodes_count(String plan_nodes_count) {
        this.plan_nodes_count = plan_nodes_count;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }
}
