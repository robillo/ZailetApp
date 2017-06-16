package com.appbusters.robinkamboj.zailetapp.model;

public class topics {
    /**
     * id : 1
     * interest : Science
     * cover : topic_images/in_science.jpg
     * time : 2015-12-30 01:59:26
     */

    private String id;
    private String interest;
    private String cover;
    private String time;

    public topics(String id, String interest, String cover, String time) {
        this.id = id;
        this.interest = interest;
        this.cover = cover;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
