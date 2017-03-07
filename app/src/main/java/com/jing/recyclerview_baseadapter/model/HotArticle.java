package com.jing.recyclerview_baseadapter.model;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/3.
 */

public class HotArticle {

    /**
     * date : 20170303
     * stories : [{"images":["http://pic1.zhimg.com/64f19e4bb4e2c331df9c9ecac0bdab6c.jpg"],"type":0,"id":9262827,"ga_prefix":"030315","title":"Nintendo Switch 开售，不过先别急着买"},{"images":["http://pic4.zhimg.com/eabd683f4e8a53d4457cc5c3ad28ca1f.jpg"],"type":0,"id":9262789,"ga_prefix":"030314","title":"董卿在《朗读者》里读的「血脉偾张」和「老舍」是正确的吗？"},{"images":["http://pic3.zhimg.com/e8ab7f725d3417b0afa0aadc5eb1feca.jpg"],"type":0,"id":9262403,"ga_prefix":"030313","title":"创始人身家一度超马云，顺丰的市值被高估了吗？"},{"images":["http://pic4.zhimg.com/edffd1f20c0dd84f375e23f3645a58e3.jpg"],"type":0,"id":9259888,"ga_prefix":"030312","title":"大误 · 已知我交往过所有血型的女孩"},{"images":["http://pic4.zhimg.com/51eca748276daf0076f360ca5660ea33.jpg"],"type":0,"id":9262375,"ga_prefix":"030311","title":"一个这是我们依然在争论的问题：「什么是星系？」"},{"images":["http://pic2.zhimg.com/6358d159b8b76c40ea457eede38ae559.jpg"],"type":0,"id":9261383,"ga_prefix":"030310","title":"用「跟我出去走走就好了」关心抑郁患者，错在哪儿了？"},{"images":["http://pic2.zhimg.com/16d15e44b6a86dd29a5876b71221633d.jpg"],"type":0,"id":9258593,"ga_prefix":"030309","title":"让 Facebook 日进斗金的广告，效果可能是个「玄学」"},{"title":"觉得自己认得鸵鸟，那你说这图里左边和右边的哪个是？","ga_prefix":"030308","images":["http://pic4.zhimg.com/d5f4f7573a7426c2dd4d53ac0a3de143.jpg"],"multipic":true,"type":0,"id":9261328},{"images":["http://pic4.zhimg.com/6a1b5d81cd235db6dd4cbd52f1525517.jpg"],"type":0,"id":9255892,"ga_prefix":"030307","title":"知道防晒很重要，但每次涂防晒霜整个脸都白花花的，好烦"},{"images":["http://pic3.zhimg.com/c48c277a2f2f5e866f0e2be0c1762ffe.jpg"],"type":0,"id":9261535,"ga_prefix":"030307","title":"目前人脸识别技术的挑战是什么？"},{"images":["http://pic1.zhimg.com/83841798e6472cf3df790c9b416f834c.jpg"],"type":0,"id":9261474,"ga_prefix":"030307","title":"你在使用共享单车吗？体验怎么样？"},{"images":["http://pic2.zhimg.com/6e1d1a2f49adfd5cadce37b13d424915.jpg"],"type":0,"id":9256034,"ga_prefix":"030306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/a4f456692c4fca8c703c459c1ea12bbe.jpg","type":0,"id":9262827,"ga_prefix":"030315","title":"Nintendo Switch 开售，不过先别急着买"},{"image":"http://pic2.zhimg.com/dafd4e0b08b4eac9e37c7a03c08f57f9.jpg","type":0,"id":9262789,"ga_prefix":"030314","title":"董卿在《朗读者》里读的「血脉偾张」和「老舍」是正确的吗？"},{"image":"http://pic2.zhimg.com/e5d147462cce4344071e597089d81bc1.jpg","type":0,"id":9262403,"ga_prefix":"030313","title":"创始人身家一度超马云，顺丰的市值被高估了吗？"},{"image":"http://pic2.zhimg.com/a558f86dfcec91d53905c79ed873f1b1.jpg","type":0,"id":9258593,"ga_prefix":"030309","title":"让 Facebook 日进斗金的广告，效果可能是个「玄学」"},{"image":"http://pic4.zhimg.com/53b4e02ee541a19f4fb9cb1c7fd0dd8f.jpg","type":0,"id":9261474,"ga_prefix":"030307","title":"你在使用共享单车吗？体验怎么样？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic1.zhimg.com/64f19e4bb4e2c331df9c9ecac0bdab6c.jpg"]
         * type : 0
         * id : 9262827
         * ga_prefix : 030315
         * title : Nintendo Switch 开售，不过先别急着买
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic3.zhimg.com/a4f456692c4fca8c703c459c1ea12bbe.jpg
         * type : 0
         * id : 9262827
         * ga_prefix : 030315
         * title : Nintendo Switch 开售，不过先别急着买
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
