package com.lanou.project.chanyouji.Class;

import java.util.List;

/**
 * Created by lanouhn on 16/9/28.
 */
public class Node {

    /**
     * id : 2906901
     * row_order : 0
     * score : 0
     * comment : null
     * tips : null
     * entry_id : null
     * lat : 0
     * lng : 0
     * entry_type : null
     * user_entry : false
     * entry_name : null
     * attraction_type : null
     * updated_at : 1474347507
     * notes : [{"id":16490715,"row_order":-6291455,"layout":"full","col":2,"description":"住的公寓楼下","updated_at":1474822408,"photo":{"id":15164954,"image_width":1600,"image_height":1063,"image_file_size":272290,"exif_lat":null,"exif_lng":null,"exif_date_time_original":1472479339,"url":"http://p.chanyouji.cn/595230/1474347559145p1at2vau3o1ta795ubs31cj9deln.jpg"}}]
     */

    private int id;
    private String comment;
    private String entry_name;
    /**
     * id : 16490715
     * row_order : -6291455
     * layout : full
     * col : 2
     * description : 住的公寓楼下
     * updated_at : 1474822408
     * photo : {"id":15164954,"image_width":1600,"image_height":1063,"image_file_size":272290,"exif_lat":null,"exif_lng":null,"exif_date_time_original":1472479339,"url":"http://p.chanyouji.cn/595230/1474347559145p1at2vau3o1ta795ubs31cj9deln.jpg"}
     */

    private List<NotesBean> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getEntry_name() {
        return entry_name;
    }

    public void setEntry_name(String entry_name) {
        this.entry_name = entry_name;
    }


    public List<NotesBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NotesBean> notes) {
        this.notes = notes;
    }

    public static class NotesBean {
        private int id;
        private String description;
        /**
         * id : 15164954
         * image_width : 1600
         * image_height : 1063
         * image_file_size : 272290
         * exif_lat : null
         * exif_lng : null
         * exif_date_time_original : 1472479339
         * url : http://p.chanyouji.cn/595230/1474347559145p1at2vau3o1ta795ubs31cj9deln.jpg
         */

        private PhotoBean photo;

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


        public PhotoBean getPhoto() {
            return photo;
        }

        public void setPhoto(PhotoBean photo) {
            this.photo = photo;
        }

        public static class PhotoBean {

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
