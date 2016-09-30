package com.lanou.project.chanyouji.Raiders;

import java.util.List;

/**
 * Created by lanouhn on 16/9/18.
 */
public class CountryBrief {

    /**
     * id : 55
     * name_zh_cn : 日本
     * name_en : Japan
     * poi_count : 1010
     * plans_count : 6
     * articles_count : 6
     * contents_count : 2438
     * destination_trips_count : 4195
     * locked : false
     * wiki_app_publish : true
     * updated_at : 1457039212
     * image_url : http://m.chanyouji.cn/destinations/55-landscape.jpg
     * guides_count : 7
     * destination_contents : [{"name":"关于日本","description_html":"<p>日本，由北海道、本州、四国、九州四个大岛和六千多个小岛组成的东亚岛国。<br> 日剧，动漫，铁路，日料，樱花，枫叶，温泉，这些美好的关键词拼出了日本最初的印象。<\/p> <p>日本国土面积不算特别大，旅行资源却十分丰富，自然风景方面，这里有漫长的美丽海岸线，贯穿全境的山川湖泊，各种火山温泉以及冲绳适宜潜水的蓝洞和珊瑚礁。<br> 人文方面则有着更大的吸引力，无论你是二次元文化爱好者，科技迷或铁路控，或对古建筑、神殿、庙宇、歌舞伎、茶艺有兴趣，日本都能满足你的好奇心。当然，美食也是另一个让你爱上日本的理由。<\/p> <p>随着日币汇率的持续走低，和廉价航线覆盖面的扩大，去日本旅行的性价比也正变得越来越高。<\/p> <strong>#适宜旅行季节#<\/strong> <p>总的来说，日本的最佳旅行时间是春秋两季。<\/p> <p>3-5月的樱花，从九州开到北海道，梦幻景色每年都吸引大批追樱人，樱花的花期很短，通常只开1周，每年开发时间还略有不同，所以有追樱计划的话还需要关注当年樱花前线的时间变化。<\/p> <p>10-11月则是枫叶季，这时气候宜人，层林尽染，也是旅行的好时间，尤其是京都那一片，古色古香的建筑在红叶中份外迷人。<\/p> <p>而炎热的夏季和寒冷的冬季，虽然不是日本大部分地区的最佳旅行时节，但却是北海道最适合旅行的季节。<br> 夏季的北海道富良野，大片的薰衣草花田可媲美普罗旺斯，美瑛的拼布之路和彩带般的五彩花丘更让人流连忘返。<br> 而冬季去北海道则可以去体验冬季限定的特色蒸汽火车、坐着破冰船去看流冰、泡温泉感受冰火两重天。<\/p> <strong>#面积与人口#<\/strong> <p>日本国土面积37.8万平方公里左右，人口超过1.2亿，是世界人口数量第10大的国家，首都东京及周边的数县构成的首都圈居住了3千万以上的人口，是世界最大的都市圈。<\/p> <strong>#时差#<\/strong> <p>日本时间比中国早1个小时，即日本上午8点的时候，北京时间是上午7点。<\/p> "}]
     * intro : {"notes":[{"description":"日本，由北海道、本州、四国、九州四个大岛和各小岛组成的东亚岛国。日剧，动漫，铁路，日料，樱花，枫叶，温泉\u2026\u2026这些美好的关键词拼出对日本旅行最初的向往。","photo_url":"http://p.chanyouji.cn/95934/1389868262641p18ed9l94c1p071jd91ao3dmd1gli2.jpg"}]}
     */

    private String id;
    private String name_zh_cn;
    private String name_en;
    private int poi_count;
    private int plans_count;
    private int articles_count;
    private int contents_count;
    private int destination_trips_count;
    private boolean locked;
    private boolean wiki_app_publish;
    private int updated_at;
    private String image_url;
    private int guides_count;
    private IntroBean intro;
    /**
     * name : 关于日本
     * description_html : <p>日本，由北海道、本州、四国、九州四个大岛和六千多个小岛组成的东亚岛国。<br> 日剧，动漫，铁路，日料，樱花，枫叶，温泉，这些美好的关键词拼出了日本最初的印象。</p> <p>日本国土面积不算特别大，旅行资源却十分丰富，自然风景方面，这里有漫长的美丽海岸线，贯穿全境的山川湖泊，各种火山温泉以及冲绳适宜潜水的蓝洞和珊瑚礁。<br> 人文方面则有着更大的吸引力，无论你是二次元文化爱好者，科技迷或铁路控，或对古建筑、神殿、庙宇、歌舞伎、茶艺有兴趣，日本都能满足你的好奇心。当然，美食也是另一个让你爱上日本的理由。</p> <p>随着日币汇率的持续走低，和廉价航线覆盖面的扩大，去日本旅行的性价比也正变得越来越高。</p> <strong>#适宜旅行季节#</strong> <p>总的来说，日本的最佳旅行时间是春秋两季。</p> <p>3-5月的樱花，从九州开到北海道，梦幻景色每年都吸引大批追樱人，樱花的花期很短，通常只开1周，每年开发时间还略有不同，所以有追樱计划的话还需要关注当年樱花前线的时间变化。</p> <p>10-11月则是枫叶季，这时气候宜人，层林尽染，也是旅行的好时间，尤其是京都那一片，古色古香的建筑在红叶中份外迷人。</p> <p>而炎热的夏季和寒冷的冬季，虽然不是日本大部分地区的最佳旅行时节，但却是北海道最适合旅行的季节。<br> 夏季的北海道富良野，大片的薰衣草花田可媲美普罗旺斯，美瑛的拼布之路和彩带般的五彩花丘更让人流连忘返。<br> 而冬季去北海道则可以去体验冬季限定的特色蒸汽火车、坐着破冰船去看流冰、泡温泉感受冰火两重天。</p> <strong>#面积与人口#</strong> <p>日本国土面积37.8万平方公里左右，人口超过1.2亿，是世界人口数量第10大的国家，首都东京及周边的数县构成的首都圈居住了3千万以上的人口，是世界最大的都市圈。</p> <strong>#时差#</strong> <p>日本时间比中国早1个小时，即日本上午8点的时候，北京时间是上午7点。</p>
     */

    private List<DestinationContentsBean> destination_contents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getPoi_count() {
        return poi_count;
    }

    public void setPoi_count(int poi_count) {
        this.poi_count = poi_count;
    }

    public int getPlans_count() {
        return plans_count;
    }

    public void setPlans_count(int plans_count) {
        this.plans_count = plans_count;
    }

    public int getArticles_count() {
        return articles_count;
    }

    public void setArticles_count(int articles_count) {
        this.articles_count = articles_count;
    }

    public int getContents_count() {
        return contents_count;
    }

    public void setContents_count(int contents_count) {
        this.contents_count = contents_count;
    }

    public int getDestination_trips_count() {
        return destination_trips_count;
    }

    public void setDestination_trips_count(int destination_trips_count) {
        this.destination_trips_count = destination_trips_count;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isWiki_app_publish() {
        return wiki_app_publish;
    }

    public void setWiki_app_publish(boolean wiki_app_publish) {
        this.wiki_app_publish = wiki_app_publish;
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

    public int getGuides_count() {
        return guides_count;
    }

    public void setGuides_count(int guides_count) {
        this.guides_count = guides_count;
    }

    public IntroBean getIntro() {
        return intro;
    }

    public void setIntro(IntroBean intro) {
        this.intro = intro;
    }

    public List<DestinationContentsBean> getDestination_contents() {
        return destination_contents;
    }

    public void setDestination_contents(List<DestinationContentsBean> destination_contents) {
        this.destination_contents = destination_contents;
    }

    public static class IntroBean {
        /**
         * description : 日本，由北海道、本州、四国、九州四个大岛和各小岛组成的东亚岛国。日剧，动漫，铁路，日料，樱花，枫叶，温泉……这些美好的关键词拼出对日本旅行最初的向往。
         * photo_url : http://p.chanyouji.cn/95934/1389868262641p18ed9l94c1p071jd91ao3dmd1gli2.jpg
         */

        private List<NotesBean> notes;

        public List<NotesBean> getNotes() {
            return notes;
        }

        public void setNotes(List<NotesBean> notes) {
            this.notes = notes;
        }

        public static class NotesBean {
            private String description;
            private String photo_url;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }
        }
    }

    public static class DestinationContentsBean {
        private String name;
        private String description_html;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription_html() {
            return description_html;
        }

        public void setDescription_html(String description_html) {
            this.description_html = description_html;
        }
    }
}
