package com.lanou.project.chanyouji.Class;

import java.util.List;

/**
 * Created by lanouhn on 16/9/29.
 */
public class Tripday {

    /**
     * trip_date : 2016-08-25
     * nodes : [{"id":2910450,"comment":"null","entry_name":"null","notes":[{"description":"上海飞北京的班机，中途为了避雷，去山东溜了一趟弯！","photo":{"url":"http://p.chanyouji.cn/595686/1474621319454p1atb4e4vt8ve118qlodo521qcfr.jpg"}}]}]
     */

    private String trip_date;
    /**
     * id : 2910450
     * comment : null
     * entry_name : null
     * notes : [{"description":"上海飞北京的班机，中途为了避雷，去山东溜了一趟弯！","photo":{"url":"http://p.chanyouji.cn/595686/1474621319454p1atb4e4vt8ve118qlodo521qcfr.jpg"}}]
     */

    private List<NodesBean> nodes;

    public String getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(String trip_date) {
        this.trip_date = trip_date;
    }

    public List<NodesBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesBean> nodes) {
        this.nodes = nodes;
    }

    public static class NodesBean {
        private int id;
        private String comment;
        private String entry_name;
        /**
         * description : 上海飞北京的班机，中途为了避雷，去山东溜了一趟弯！
         * photo : {"url":"http://p.chanyouji.cn/595686/1474621319454p1atb4e4vt8ve118qlodo521qcfr.jpg"}
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
            private String description;
            /**
             * url : http://p.chanyouji.cn/595686/1474621319454p1atb4e4vt8ve118qlodo521qcfr.jpg
             */

            private PhotoBean photo;

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
}
