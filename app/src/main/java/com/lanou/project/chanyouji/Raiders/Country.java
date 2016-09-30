package com.lanou.project.chanyouji.Raiders;

import java.util.List;

/**
 * Created by lanouhn on 16/9/14.
 */
public class Country {


    /**
     * category : 1
     * destinations : [{"id":55,"image_url":"http://m.chanyouji.cn/destinations/55-portrait.jpg","lat":36.2048,"lng":138.253,"name_en":"Japan","name_zh_cn":"日本","poi_count":1010,"updated_at":1457039212},{"id":45,"image_url":"http://m.chanyouji.cn/destinations/45-portrait.jpg","lat":15.87,"lng":100.993,"name_en":"Thailand","name_zh_cn":"泰国","poi_count":572,"updated_at":1471385644},{"id":47,"image_url":"http://m.chanyouji.cn/destinations/47-portrait.jpg","lat":35.9078,"lng":127.767,"name_en":"South Korea","name_zh_cn":"韩国","poi_count":309,"updated_at":1456348522},{"id":71,"image_url":"http://m.chanyouji.cn/destinations/71-portrait.jpg","lat":4.21048,"lng":101.976,"name_en":"Malaysia","name_zh_cn":"马来西亚","poi_count":298,"updated_at":1466633120},{"id":53,"image_url":"http://m.chanyouji.cn/destinations/53-portrait.jpg","lat":1.35208,"lng":103.82,"name_en":"Singapore","name_zh_cn":"新加坡","poi_count":177,"updated_at":1450816779},{"id":54,"image_url":"http://m.chanyouji.cn/destinations/54-portrait.jpg","lat":12.5657,"lng":104.991,"name_en":"Cambodia","name_zh_cn":"柬埔寨","poi_count":96,"updated_at":1448657986},{"id":49,"image_url":"http://m.chanyouji.cn/destinations/49-portrait.jpg","lat":14.0583,"lng":108.277,"name_en":"Vietnam","name_zh_cn":"越南","poi_count":269,"updated_at":1471299048},{"id":76,"image_url":"http://m.chanyouji.cn/destinations/76-portait.jpg","lat":-0.789275,"lng":113.921,"name_en":"Indonesia","name_zh_cn":"印度尼西亚","poi_count":206,"updated_at":1471385646},{"id":73,"image_url":"http://m.chanyouji.cn/destinations/73-portrait.jpg","lat":12.8797,"lng":121.774,"name_en":"Philippines","name_zh_cn":"菲律宾","poi_count":268,"updated_at":1453754720},{"id":48,"image_url":"http://cyjm.qiniudn.com/destinations/48-portrait.jpg","lat":7.87305,"lng":80.7718,"name_en":"Sri Lanka","name_zh_cn":"斯里兰卡","poi_count":173,"updated_at":1458939484},{"id":56,"image_url":"http://m.chanyouji.cn/destinations/56-portrait.png","lat":28.3949,"lng":84.124,"name_en":"Nepal","name_zh_cn":"尼泊尔","poi_count":96,"updated_at":1458333971},{"id":50,"image_url":"http://m.chanyouji.cn/destinations/50-portrait1.jpg","lat":21.914,"lng":95.9562,"name_en":"Myanmar","name_zh_cn":"缅甸","poi_count":158,"updated_at":1433737537},{"id":75,"image_url":"http://m.chanyouji.cn/destinations/75-portrait.jpg","lat":19.8563,"lng":102.495,"name_en":"Laos","name_zh_cn":"老挝","poi_count":69,"updated_at":1448657987},{"id":51,"image_url":"http://m.chanyouji.cn/destinations/51-portrait.jpg","lat":40.3399,"lng":127.51,"name_en":"North Korea","name_zh_cn":"朝鲜","poi_count":21,"updated_at":1401437750}]
     */

    private String category;
    /**
     * id : 55
     * image_url : http://m.chanyouji.cn/destinations/55-portrait.jpg
     * lat : 36.2048
     * lng : 138.253
     * name_en : Japan
     * name_zh_cn : 日本
     * poi_count : 1010
     * updated_at : 1457039212
     */

    private List<DestinationsBean> destinations;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<DestinationsBean> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DestinationsBean> destinations) {
        this.destinations = destinations;
    }

    public static class DestinationsBean {
        private String id;
        private String image_url;
        private double lat;
        private double lng;
        private String name_en;
        private String name_zh_cn;
        private String poi_count;
        private int updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }

        public String getPoi_count() {
            return poi_count;
        }

        public void setPoi_count(String poi_count) {
            this.poi_count = poi_count;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }
    }
}
