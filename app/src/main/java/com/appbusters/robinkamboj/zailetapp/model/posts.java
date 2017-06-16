package com.appbusters.robinkamboj.zailetapp.model;

public class posts {

    public posts(String id, String title, String time, String cover, String thumbnail, String description, String ed_id) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.cover = cover;
        this.thumbnail = thumbnail;
        this.description = description;
        this.ed_id = ed_id;
    }

    /**
     * id : 685
     * title : Science without religion is lame. Religion without science is blind.
     * time : 2016-09-27 05:56:28
     * cover : users/50/posts/ZT-2016-09-26-05-52-50.jpg
     * thumbnail : users/50/posts/ZT-2016-09-26-05-52-50.jpg-thumb.jpg
     * description : In modern times religion has been losing out to science as new breakthroughs have been shattering the myths and superstitions of religious teachings. But the moral teachings still form the basis of the ethics and value system we espouse to reach.
     * ed_id : 50
     */



    private String id;
    private String title;
    private String time;
    private String cover;
    private String thumbnail;
    private String description;
    private String ed_id;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEd_id() {
        return ed_id;
    }

    public void setEd_id(String ed_id) {
        this.ed_id = ed_id;
    }
}
