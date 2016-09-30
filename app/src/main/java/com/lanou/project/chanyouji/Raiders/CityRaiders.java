package com.lanou.project.chanyouji.Raiders;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by lanouhn on 16/9/19.
 */
public class CityRaiders  implements Parcelable{


    /**
     * category_type : 0
     * pages : [{"id":505,"title":"游玩指南"},{"id":23158,"title":"攻略亮点早知道"},{"id":508,"title":"最佳旅行时间"},{"id":513,"title":"路线与费用"},{"id":20180,"title":"知名旅行家说"}]
     */

    private int category_type;
    /**
     * id : 505
     * title : 游玩指南
     */

    private List<PagesBean> pages;

    protected CityRaiders(Parcel in) {
        category_type = in.readInt();
        pages = in.createTypedArrayList(PagesBean.CREATOR);
    }

    public static final Creator<CityRaiders> CREATOR = new Creator<CityRaiders>() {
        @Override
        public CityRaiders createFromParcel(Parcel in) {
            return new CityRaiders(in);
        }

        @Override
        public CityRaiders[] newArray(int size) {
            return new CityRaiders[size];
        }
    };

    public int getCategory_type() {
        return category_type;
    }

    public void setCategory_type(int category_type) {
        this.category_type = category_type;
    }

    public List<PagesBean> getPages() {
        return pages;
    }

    public void setPages(List<PagesBean> pages) {
        this.pages = pages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(category_type);
        dest.writeTypedList(pages);
    }

    public static class PagesBean implements Parcelable{
        private String id;
        private String title;
        /**
         * id : 1149
         * title :
         * description_user_ids : {}
         * ctrip_attraction_ids : null
         * description : 说到泰国，很多人的第一印象可能是人妖，其实这只是泰国旅行很小的组成部分。 泰国拥有美丽的沙滩海岛、丰富的历史古迹、充满活力的夜生活和各种美食。无论是海岛控或小清新，都能在这里找到自己喜欢的旅行方式。 泰国旅行地以中部的首都曼谷、北部的清迈和南部的诸多海岛为主。 泰国的旅游业发达，消费低廉，还有为数众多的华人旅社，即便是初次出国自由行的人也能轻松应对。
         * travel_date : null
         *  : null
         * attractions : []
         * hotels : []
         * pages : []
         * photos : [{"image_url":"http://w.chanyouji.cn/1407399960999p18unp68cnhll6m91u6vt2nuqr1.jpg","image_width":614,"image_height":1000,"description":"泰国游览地图","trip_id":null,"note_id":null,"user_name":null}]
         * items : []
         */
        private List<ChildrenBean> children;

        protected PagesBean(Parcel in) {
            id = in.readString();
            title = in.readString();
            children = in.createTypedArrayList(ChildrenBean.CREATOR);
        }

        public static final Creator<PagesBean> CREATOR = new Creator<PagesBean>() {
            @Override
            public PagesBean createFromParcel(Parcel in) {
                return new PagesBean(in);
            }

            @Override
            public PagesBean[] newArray(int size) {
                return new PagesBean[size];
            }
        };

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

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(title);
            dest.writeTypedList(children);
        }

        public static class ChildrenBean  implements Parcelable{


            /**
             * id : 504
             * title : 其他实用贴士
             * sections : [{"id":2611,"title":"仔细检查购物袋很重要","description_user_ids":{},"ctrip_attraction_ids":null,"description":"在泰国商场购物时，会每样东西给装一个袋子。所以马大哈们要注意了，最好把所有买的东西都汇总到一个袋子里，免得在最后打包装行李箱的时候误认为垃圾扔掉了。我就那个马大哈！","travel_date":"2013-01 出行","user":{"id":30760,"name":"天机美人"},"attractions":[],"hotels":[],"pages":[],"photos":[],"items":[]},{"id":53425,"title":"别忘记打印行程单","description_user_ids":{},"ctrip_attraction_ids":null,"description":"需要经历转机到泰国的朋友们（特别是亚航，由于是廉价航空所以转机时需要自己凭行程单到窗口提取转程机票），所以千万别忘记行程单。我第一次到去泰国在吉隆坡转机就遇到了这样的情况，碰到一群不会说英语的人也是这样的情况，所以做好一切准备才会万无一失。 #提醒# 1、如果确实忘记打印行程单，请在国内有网络的情况下将行程单电子版保存在手机里； 2、请能沟通的热情人帮忙（学好基本口语你可以走得更远）","travel_date":"2015-05 出行","user":{"id":563198,"name":"斯芬克斯怪怪喵"},"attractions":[],"hotels":[],"pages":[],"photos":[],"items":[]}]
             */

            private String id;
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

            protected ChildrenBean(Parcel in) {
                id = in.readString();
                title = in.readString();
                sections = in.createTypedArrayList(SectionsBean.CREATOR);
            }

            public static final Creator<ChildrenBean> CREATOR = new Creator<ChildrenBean>() {
                @Override
                public ChildrenBean createFromParcel(Parcel in) {
                    return new ChildrenBean(in);
                }

                @Override
                public ChildrenBean[] newArray(int size) {
                    return new ChildrenBean[size];
                }
            };

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


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(title);
                dest.writeTypedList(sections);
            }




            public List<SectionsBean> getSections() {
                return sections;
            }
            public void setSections(List<SectionsBean> sections) {
                this.sections = sections;
            }

            public static class SectionsBean implements Parcelable{
                private int id;
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






                public Description_user_idsBean getDescription_user_ids() {
                    return description_user_ids;
                }

                public void setDescription_user_idsr(Description_user_idsBean description_user_ids) {
                    this.description_user_ids = description_user_ids;
                }

                protected SectionsBean(Parcel in) {
                    id = in.readInt();
                    title = in.readString();
                    ctrip_attraction_ids = in.readString();
                    description = in.readString();
                    travel_date = in.readString();
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        user = in.readTypedObject(UserBean.CREATOR);
//                    }
                    attractions = in.createTypedArrayList(AttractionsBean.CREATOR);
                    pages = in.createTypedArrayList(PagesBeans.CREATOR);
                    photos = in.createTypedArrayList(PhotosBean.CREATOR);
                    user = in.readParcelable(UserBean.class.getClassLoader());



                }

                public static final Creator<SectionsBean> CREATOR = new Creator<SectionsBean>() {
                    @Override
                    public SectionsBean createFromParcel(Parcel in) {
                        return new SectionsBean(in);
                    }

                    @Override
                    public SectionsBean[] newArray(int size) {
                        return new SectionsBean[size];
                    }
                };
                @Override
                public int describeContents() {
                    return 0;
                }

                @TargetApi(Build.VERSION_CODES.M)
                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(id);
                    dest.writeString(title);
                    dest.writeString(ctrip_attraction_ids);
                    dest.writeString(description);
                    dest.writeString(travel_date);
                    dest.writeTypedList(attractions);
                    dest.writeTypedList(pages);
                    dest.writeTypedList(photos);
//                    dest.writeValue(user);

                    dest.writeParcelable(user, flags);


                }

                public static class Description_user_idsBean implements Parcelable{

                    protected Description_user_idsBean(Parcel in) {
                    }

                    public static final Creator<Description_user_idsBean> CREATOR = new Creator<Description_user_idsBean>() {
                        @Override
                        public Description_user_idsBean createFromParcel(Parcel in) {
                            return new Description_user_idsBean(in);
                        }

                        @Override
                        public Description_user_idsBean[] newArray(int size) {
                            return new Description_user_idsBean[size];
                        }
                    };

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                    }
                }




                public List<PagesBeans> getPages() {
                    return pages;
                }

                public void setPages(List<PagesBeans> pages) {
                    this.pages = pages;
                }


                public static class PagesBeans implements Parcelable{

                    /**
                     * id : 91
                     * destination_id : 55
                     * title : 日本 - 机场指南
                     */

                    private String id;
                    private String destination_id;
                    private String title;

                    protected PagesBeans(Parcel in) {
                        id = in.readString();
                        destination_id = in.readString();
                        title = in.readString();
                    }

                    public static final Creator<PagesBeans> CREATOR = new Creator<PagesBeans>() {
                        @Override
                        public PagesBeans createFromParcel(Parcel in) {
                            return new PagesBeans(in);
                        }

                        @Override
                        public PagesBeans[] newArray(int size) {
                            return new PagesBeans[size];
                        }
                    };

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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(id);
                        dest.writeString(destination_id);
                        dest.writeString(title);
                    }
                }






                public List<AttractionsBean> getAttractions() {
                    return attractions;
                }

                public void setAttractions(List<AttractionsBean> attractions) {
                    this.attractions = attractions;
                }

                public static class AttractionsBean implements Parcelable{


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

                    protected AttractionsBean(Parcel in) {
                        id = in.readInt();
                        name = in.readString();
                        lat = in.readString();
                        lng = in.readString();
                        attraction_type = in.readString();
                        ctrip_id = in.readString();
                        ctrip_url = in.readString();
                    }

                    public static final Creator<AttractionsBean> CREATOR = new Creator<AttractionsBean>() {
                        @Override
                        public AttractionsBean createFromParcel(Parcel in) {
                            return new AttractionsBean(in);
                        }

                        @Override
                        public AttractionsBean[] newArray(int size) {
                            return new AttractionsBean[size];
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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(id);
                        dest.writeString(name);
                        dest.writeString(lat);
                        dest.writeString(lng);
                        dest.writeString(attraction_type);
                        dest.writeString(ctrip_id);
                        dest.writeString(ctrip_url);
                    }
                }







                public List<PhotosBean> getPhotos() {
                    return photos;
                }

                public void setPhotos(List<PhotosBean> photos) {
                    this.photos = photos;
                }

                public static class PhotosBean implements Parcelable{

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
                    private int image_width;
                    private int image_height;
                    private String description;
                    private String trip_id;
                    private String note_id;
                    private String user_name;

                    protected PhotosBean(Parcel in) {
                        image_url = in.readString();
                        image_width = in.readInt();
                        image_height = in.readInt();
                        description = in.readString();
                        trip_id = in.readString();
                        note_id = in.readString();
                        user_name = in.readString();
                    }

                    public static final Creator<PhotosBean> CREATOR = new Creator<PhotosBean>() {
                        @Override
                        public PhotosBean createFromParcel(Parcel in) {
                            return new PhotosBean(in);
                        }

                        @Override
                        public PhotosBean[] newArray(int size) {
                            return new PhotosBean[size];
                        }
                    };

                    public String getImage_url() {
                        return image_url;
                    }

                    public void setImage_url(String image_url) {
                        this.image_url = image_url;
                    }

                    public int getImage_width() {
                        return image_width;
                    }

                    public void setImage_width(int image_width) {
                        this.image_width = image_width;
                    }

                    public int getImage_height() {
                        return image_height;
                    }

                    public void setImage_height(int image_height) {
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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(image_url);
                        dest.writeInt(image_width);
                        dest.writeInt(image_height);
                        dest.writeString(description);
                        dest.writeString(trip_id);
                        dest.writeString(note_id);
                        dest.writeString(user_name);
                    }
                }






                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public static class UserBean implements Parcelable{
                    private int id;
                    private String name;

                    protected UserBean(Parcel in) {
                        id = in.readInt();
                        name = in.readString();
                    }

                    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
                        @Override
                        public UserBean createFromParcel(Parcel in) {
                            return new UserBean(in);
                        }

                        @Override
                        public UserBean[] newArray(int size) {
                            return new UserBean[size];
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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(id);
                        dest.writeString(name);
                    }
                }
            }
        }
    }
}
