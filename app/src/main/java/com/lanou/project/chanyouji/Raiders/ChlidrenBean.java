package com.lanou.project.chanyouji.Raiders;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by lanouhn on 16/9/24.
 */
public class ChlidrenBean extends Application {



    /**
     * id : 504
     * title : 其他实用贴士
     * sections : [{"id":2611,"title":"仔细检查购物袋很重要","description_user_ids":{},"ctrip_attraction_ids":null,"description":"在泰国商场购物时，会每样东西给装一个袋子。所以马大哈们要注意了，最好把所有买的东西都汇总到一个袋子里，免得在最后打包装行李箱的时候误认为垃圾扔掉了。我就那个马大哈！","travel_date":"2013-01 出行","user":{"id":30760,"name":"天机美人"},"attractions":[],"hotels":[],"pages":[],"photos":[],"items":[]},{"id":53425,"title":"别忘记打印行程单","description_user_ids":{},"ctrip_attraction_ids":null,"description":"需要经历转机到泰国的朋友们（特别是亚航，由于是廉价航空所以转机时需要自己凭行程单到窗口提取转程机票），所以千万别忘记行程单。我第一次到去泰国在吉隆坡转机就遇到了这样的情况，碰到一群不会说英语的人也是这样的情况，所以做好一切准备才会万无一失。 #提醒# 1、如果确实忘记打印行程单，请在国内有网络的情况下将行程单电子版保存在手机里； 2、请能沟通的热情人帮忙（学好基本口语你可以走得更远）","travel_date":"2015-05 出行","user":{"id":563198,"name":"斯芬克斯怪怪喵"},"attractions":[],"hotels":[],"pages":[],"photos":[],"items":[]}]
     */

    private int id;
    private String title;
    /**
     * id : 2611
     * title : 仔细检查购物袋很重要
     * description_user_ids : {}
     * ctrip_attraction_ids : null
     * description : 在泰国商场购物时，会每样东西给装一个袋子。所以马大哈们要注意了，最好把所有买的东西都汇总到一个袋子里，免得在最后打包装行李箱的时候误认为垃圾扔掉了。我就那个马大哈！
     * travel_date : 2013-01 出行
     * user : {"id":30760,"name":"天机美人"}
     * attractions : []
     * hotels : []
     * pages : []
     * photos : []
     * items : []
     */

    private List<SectionsBean> sections;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SectionsBean> getSections() {
        return sections;
    }

    public void setSections(List<SectionsBean> sections) {
        this.sections = sections;
    }



    public static class SectionsBean {
        private String id;
        private String title;
        private Description_user_idsBean description_user_ids;
        private String ctrip_attraction_ids;
        private String description;
        private String travel_date;
        private UserBean user;
        private List<AttractionsBean> attractions;
        private List<PagesBeans> pages;
        private List<PhotosBean> photos;
        private List items;
        private List hotels;
        /**
         * id : 30760
         * name : 天机美人
         */


        public Description_user_idsBean getDescription_user_ids() {
            return description_user_ids;
        }

        public void setDescription_user_idsr(Description_user_idsBean description_user_ids) {
            this.description_user_ids = description_user_ids;
        }

        public static class Description_user_idsBean {

        }


        public List<PagesBeans> getPages() {
            return pages;
        }

        public void setPages(List<PagesBeans> pages) {
            this.pages = pages;
        }




        public static class PagesBeans {

            /**
             * id : 91
             * destination_id : 55
             * title : 日本 - 机场指南
             */

            private String id;
            private String destination_id;
            private String title;



            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDestination_id() {
                return destination_id;
            }

            public void setDestination_id(String destination_id) {
                this.destination_id = destination_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }


        }

        public List<AttractionsBean> getAttractions() {
            return attractions;
        }

        public void setAttractions(List<AttractionsBean> attractions) {
            this.attractions = attractions;
        }




        public static class AttractionsBean {


            /**
             * id : 164602
             * name : 唐吉诃德 船桥南口店
             * lat : 35.698945
             * lng : 139.985781
             * attraction_type : shopping
             * ctrip_id : 18687313
             * ctrip_url : null
             */

            private int id;
            private String name;
            private String lat;
            private String lng;
            private String attraction_type;
            private String ctrip_id;
            private String ctrip_url;
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

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getAttraction_type() {
                return attraction_type;
            }

            public void setAttraction_type(String attraction_type) {
                this.attraction_type = attraction_type;
            }

            public String getCtrip_id() {
                return ctrip_id;
            }

            public void setCtrip_id(String ctrip_id) {
                this.ctrip_id = ctrip_id;
            }

            public String getCtrip_url() {
                return ctrip_url;
            }

            public void setCtrip_url(String ctrip_url) {
                this.ctrip_url = ctrip_url;
            }

        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }




        public static class PhotosBean {

            /**
             * image_url : http://w.chanyouji.cn/1406209570860p18tk9u49p15bf1occ1eon10sp1hs34.jpg
             * image_width : 600
             * image_height : 800
             * description :
             * trip_id : null
             * note_id : null
             * user_name : null
             */

            private String image_url;
            private String image_width;
            private String image_height;
            private String description;
            private String trip_id;
            private String note_id;
            private String user_name;

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getImage_width() {
                return image_width;
            }

            public void setImage_width(String image_width) {
                this.image_width = image_width;
            }

            public String getImage_height() {
                return image_height;
            }

            public void setImage_height(String image_height) {
                this.image_height = image_height;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTrip_id() {
                return trip_id;
            }

            public void setTrip_id(String trip_id) {
                this.trip_id = trip_id;
            }

            public String getNote_id() {
                return note_id;
            }

            public void setNote_id(String note_id) {
                this.note_id = note_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCtrip_attraction_ids() {
            return ctrip_attraction_ids;
        }

        public void setCtrip_attraction_ids(String ctrip_attraction_ids) {
            this.ctrip_attraction_ids = ctrip_attraction_ids;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTravel_date() {
            return travel_date;
        }

        public void setTravel_date(String travel_date) {
            this.travel_date = travel_date;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }



        public static class UserBean {
            private int id;
            private String name;

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

        }
    }

}
