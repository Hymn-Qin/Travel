package com.lanou.project.chanyouji.Raiders;

import java.util.List;

/**
 * Created by lanouhn on 16/9/27.
 */
public class CityTravelItem {


    /**
     * id : 35443
     * name_zh_cn : 京都清水寺
     * name_en : Kiyomizu Temple
     * description : 清水寺依山势而建的、靠数百根巨大的圆木撑起的大殿露台“清水舞台”。
     * tips_html : 京都站前搭乘市营206路
     * user_score : 4.33
     * photos_count : 9129
     * attraction_trips_count : 891
     * lat : 34.994835
     * lng : 135.784953
     * attraction_type : null
     * address : 日本京都东山区清水1丁目294
     * ctrip_id : 78812
     * updated_at : 1406091715
     * image_url : http://m.chanyouji.cn/attractions/35443.jpg
     * attractions_count : 713
     * activities_count : 10
     * restaurants_count : 20
     * attraction_trip_tags : [{"id":2219,"name":"清水寺印象","display_count":99,"attraction_contents":[{"id":9316,"description":"#京都的名片# 清水寺与金阁寺、岚山等同为京都境内最著名的名胜古迹，一年四季前来朝拜的香客或来访的观光客是络驿不绝。 清水寺是京都最古老的寺院，建于公元798年，清水寺的山号为音羽山，主要供奉千手观音。","updated_at":1389873224,"node_id":713048,"node_comments_count":0,"trip":{"id":93844,"name":"京都红叶狩","photos_count":123,"days":4,"start_date":"2013-11-28","end_date":"2013-12-01","level":3,"privacy":false,"views_count":5577,"comments_count":8,"likes_count":99,"state":"publish","source":"web","serial_id":null,"serial_position":null,"front_cover_photo_url":"http://cyj.qiniudn.com/93844/1388465555906p18d3et14ihcf6n1jmjaac1qmj2v.jpg","updated_at":1408616705,"user":{"id":34757,"name":"芒椰西米","image":"http://tp2.sinaimg.cn/1849354581/180/5671970414/0"}},"notes":[{"id":3684607,"description":"","width":1600,"height":900,"photo_url":"http://p.chanyouji.cn/93844/1388465098531p18d3et14i1gg7o6a3u8t3r10el1t.jpg","video_url":null}]}]}]
     * destination : {"id":167,"name_zh_cn":"关西"}
     * contributors : []
     * attractions : [{"id":158068,"name_zh_cn":"京都清水坂","user_score":"4.12","distance":0.00800655291183974,"image_url":"http://m.chanyouji.cn/attractions/158068.jpg"}]
     * hotels : [{"id":128520,"name_zh_cn":"& Hana Stay","distance":0.618942865869595,"image_url":"http://m.chanyouji.cn/hotels/128520.jpg"}]
     * current_user_favorite : false
     */

    private int id;
    private String name_zh_cn;
    private String name_en;
    private String description;
    private String tips_html;
    private String user_score;
    private int photos_count;
    private int attraction_trips_count;
    private String lat;
    private String lng;
    private Object attraction_type;//////////////
    private String address;
    private int ctrip_id;
    private int updated_at;
    private String image_url;
    private int attractions_count;
    private int activities_count;
    private int restaurants_count;
    /**
     * id : 167
     * name_zh_cn : 关西
     */

    private DestinationBean destination;
    private boolean current_user_favorite;
    /**
     * id : 2219
     * name : 清水寺印象
     * display_count : 99
     * attraction_contents : [{"id":9316,"description":"#京都的名片# 清水寺与金阁寺、岚山等同为京都境内最著名的名胜古迹，一年四季前来朝拜的香客或来访的观光客是络驿不绝。 清水寺是京都最古老的寺院，建于公元798年，清水寺的山号为音羽山，主要供奉千手观音。","updated_at":1389873224,"node_id":713048,"node_comments_count":0,"trip":{"id":93844,"name":"京都红叶狩","photos_count":123,"days":4,"start_date":"2013-11-28","end_date":"2013-12-01","level":3,"privacy":false,"views_count":5577,"comments_count":8,"likes_count":99,"state":"publish","source":"web","serial_id":null,"serial_position":null,"front_cover_photo_url":"http://cyj.qiniudn.com/93844/1388465555906p18d3et14ihcf6n1jmjaac1qmj2v.jpg","updated_at":1408616705,"user":{"id":34757,"name":"芒椰西米","image":"http://tp2.sinaimg.cn/1849354581/180/5671970414/0"}},"notes":[{"id":3684607,"description":"","width":1600,"height":900,"photo_url":"http://p.chanyouji.cn/93844/1388465098531p18d3et14i1gg7o6a3u8t3r10el1t.jpg","video_url":null}]}]
     */

    private List<AttractionTripTagsBean> attraction_trip_tags;
    private List<?> contributors;///////
    /**
     * id : 158068
     * name_zh_cn : 京都清水坂
     * user_score : 4.12
     * distance : 0.00800655291183974
     * image_url : http://m.chanyouji.cn/attractions/158068.jpg
     */

    private List<AttractionsBean> attractions;
    /**
     * id : 128520
     * name_zh_cn : & Hana Stay
     * distance : 0.618942865869595
     * image_url : http://m.chanyouji.cn/hotels/128520.jpg
     */

    private List<HotelsBean> hotels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_zh_cn() {
        return name_zh_cn;
    }

    public void setName_zh_cn(String name_zh_cn) {
        this.name_zh_cn = name_zh_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTips_html() {
        return tips_html;
    }

    public void setTips_html(String tips_html) {
        this.tips_html = tips_html;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public int getAttraction_trips_count() {
        return attraction_trips_count;
    }

    public void setAttraction_trips_count(int attraction_trips_count) {
        this.attraction_trips_count = attraction_trips_count;
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

    public Object getAttraction_type() {
        return attraction_type;
    }

    public void setAttraction_type(Object attraction_type) {
        this.attraction_type = attraction_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCtrip_id() {
        return ctrip_id;
    }

    public void setCtrip_id(int ctrip_id) {
        this.ctrip_id = ctrip_id;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getAttractions_count() {
        return attractions_count;
    }

    public void setAttractions_count(int attractions_count) {
        this.attractions_count = attractions_count;
    }

    public int getActivities_count() {
        return activities_count;
    }

    public void setActivities_count(int activities_count) {
        this.activities_count = activities_count;
    }

    public int getRestaurants_count() {
        return restaurants_count;
    }

    public void setRestaurants_count(int restaurants_count) {
        this.restaurants_count = restaurants_count;
    }

    public DestinationBean getDestination() {
        return destination;
    }

    public void setDestination(DestinationBean destination) {
        this.destination = destination;
    }

    public boolean isCurrent_user_favorite() {
        return current_user_favorite;
    }

    public void setCurrent_user_favorite(boolean current_user_favorite) {
        this.current_user_favorite = current_user_favorite;
    }

    public List<AttractionTripTagsBean> getAttraction_trip_tags() {
        return attraction_trip_tags;
    }

    public void setAttraction_trip_tags(List<AttractionTripTagsBean> attraction_trip_tags) {
        this.attraction_trip_tags = attraction_trip_tags;
    }

    public List<?> getContributors() {
        return contributors;
    }

    public void setContributors(List<?> contributors) {
        this.contributors = contributors;
    }

    public List<AttractionsBean> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<AttractionsBean> attractions) {
        this.attractions = attractions;
    }

    public List<HotelsBean> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelsBean> hotels) {
        this.hotels = hotels;
    }

    public static class DestinationBean {
        private int id;
        private String name_zh_cn;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }
    }

    public static class AttractionTripTagsBean {
        private int id;
        private String name;
        private int display_count;
        /**
         * id : 9316
         * description : #京都的名片# 清水寺与金阁寺、岚山等同为京都境内最著名的名胜古迹，一年四季前来朝拜的香客或来访的观光客是络驿不绝。 清水寺是京都最古老的寺院，建于公元798年，清水寺的山号为音羽山，主要供奉千手观音。
         * updated_at : 1389873224
         * node_id : 713048
         * node_comments_count : 0
         * trip : {"id":93844,"name":"京都红叶狩","photos_count":123,"days":4,"start_date":"2013-11-28","end_date":"2013-12-01","level":3,"privacy":false,"views_count":5577,"comments_count":8,"likes_count":99,"state":"publish","source":"web","serial_id":null,"serial_position":null,"front_cover_photo_url":"http://cyj.qiniudn.com/93844/1388465555906p18d3et14ihcf6n1jmjaac1qmj2v.jpg","updated_at":1408616705,"user":{"id":34757,"name":"芒椰西米","image":"http://tp2.sinaimg.cn/1849354581/180/5671970414/0"}}
         * notes : [{"id":3684607,"description":"","width":1600,"height":900,"photo_url":"http://p.chanyouji.cn/93844/1388465098531p18d3et14i1gg7o6a3u8t3r10el1t.jpg","video_url":null}]
         */

        private List<AttractionContentsBean> attraction_contents;

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

        public int getDisplay_count() {
            return display_count;
        }

        public void setDisplay_count(int display_count) {
            this.display_count = display_count;
        }

        public List<AttractionContentsBean> getAttraction_contents() {
            return attraction_contents;
        }

        public void setAttraction_contents(List<AttractionContentsBean> attraction_contents) {
            this.attraction_contents = attraction_contents;
        }

        public static class AttractionContentsBean {
            private int id;
            private String description;
            private int updated_at;
            private int node_id;
            private int node_comments_count;
            /**
             * id : 93844
             * name : 京都红叶狩
             * photos_count : 123
             * days : 4
             * start_date : 2013-11-28
             * end_date : 2013-12-01
             * level : 3
             * privacy : false
             * views_count : 5577
             * comments_count : 8
             * likes_count : 99
             * state : publish
             * source : web
             * serial_id : null
             * serial_position : null
             * front_cover_photo_url : http://cyj.qiniudn.com/93844/1388465555906p18d3et14ihcf6n1jmjaac1qmj2v.jpg
             * updated_at : 1408616705
             * user : {"id":34757,"name":"芒椰西米","image":"http://tp2.sinaimg.cn/1849354581/180/5671970414/0"}
             */

            private TripBean trip;
            /**
             * id : 3684607
             * description :
             * width : 1600
             * height : 900
             * photo_url : http://p.chanyouji.cn/93844/1388465098531p18d3et14i1gg7o6a3u8t3r10el1t.jpg
             * video_url : null
             */

            private List<NotesBean> notes;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getNode_id() {
                return node_id;
            }

            public void setNode_id(int node_id) {
                this.node_id = node_id;
            }

            public int getNode_comments_count() {
                return node_comments_count;
            }

            public void setNode_comments_count(int node_comments_count) {
                this.node_comments_count = node_comments_count;
            }

            public TripBean getTrip() {
                return trip;
            }

            public void setTrip(TripBean trip) {
                this.trip = trip;
            }

            public List<NotesBean> getNotes() {
                return notes;
            }

            public void setNotes(List<NotesBean> notes) {
                this.notes = notes;
            }

            public static class TripBean {
                private int id;
                private String name;
                private int photos_count;
                private int days;
                private String start_date;
                private String end_date;
                private int level;
                private boolean privacy;
                private int views_count;
                private int comments_count;
                private int likes_count;
                private String state;
                private String source;
                private int serial_id;
                private int serial_position;
                private String front_cover_photo_url;
                private int updated_at;
                /**
                 * id : 34757
                 * name : 芒椰西米
                 * image : http://tp2.sinaimg.cn/1849354581/180/5671970414/0
                 */

                private UserBean user;

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

                public int getDays() {
                    return days;
                }

                public void setDays(int days) {
                    this.days = days;
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

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public int getSerial_id() {
                    return serial_id;
                }

                public void setSerial_id(int serial_id) {
                    this.serial_id = serial_id;
                }

                public int getSerial_position() {
                    return serial_position;
                }

                public void setSerial_position(int serial_position) {
                    this.serial_position = serial_position;
                }

                public String getFront_cover_photo_url() {
                    return front_cover_photo_url;
                }

                public void setFront_cover_photo_url(String front_cover_photo_url) {
                    this.front_cover_photo_url = front_cover_photo_url;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
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
                    private String image;

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

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                }
            }

            public static class NotesBean {
                private int id;
                private String description;
                private int width;
                private int height;
                private String photo_url;
                private String video_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
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

                public String getVideo_url() {
                    return video_url;
                }

                public void setVideo_url(String video_url) {
                    this.video_url = video_url;
                }
            }
        }
    }

    public static class AttractionsBean {
        private int id;
        private String name_zh_cn;
        private String user_score;
        private double distance;
        private String image_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }

        public String getUser_score() {
            return user_score;
        }

        public void setUser_score(String user_score) {
            this.user_score = user_score;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }

    public static class HotelsBean {
        private int id;
        private String name_zh_cn;
        private double distance;
        private String image_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}
