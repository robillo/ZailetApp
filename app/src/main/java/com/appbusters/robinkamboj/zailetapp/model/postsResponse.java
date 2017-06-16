package com.appbusters.robinkamboj.zailetapp.model;

import java.util.List;

public class postsResponse {

    public postsResponse(posts post_info, authors author_info) {
        this.post_info = post_info;
        this.author_info = author_info;
    }

    /**
     * post_info : {"id":"685","title":"Science without religion is lame. Religion without science is blind.","time":"2016-09-27 05:56:28","cover":"users/50/posts/ZT-2016-09-26-05-52-50.jpg","thumbnail":"users/50/posts/ZT-2016-09-26-05-52-50.jpg-thumb.jpg","description":"In modern times religion has been losing out to science as new breakthroughs have been shattering the myths and superstitions of religious teachings. But the moral teachings still form the basis of the ethics and value system we espouse to reach.","ed_id":"50"}
     * author_info : {"id":"50","name":"Archit Gupta","username":"zailet_archit","dp":"users/50/dp.jpg"}
     */



    private posts post_info;
    private authors author_info;

    public posts getPost_info() {
        return post_info;
    }

    public void setPost_info(posts post_info) {
        this.post_info = post_info;
    }

    public authors getAuthor_info() {
        return author_info;
    }

    public void setAuthor_info(authors author_info) {
        this.author_info = author_info;
    }


}
