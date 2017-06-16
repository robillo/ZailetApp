package com.appbusters.robinkamboj.zailetapp.model;

import java.util.List;

/**
 * Created by robinkamboj on 16/06/17.
 */

public class postsResponseResponse {

    public postsResponseResponse(List<postsResponse> posts) {
        this.posts = posts;
    }

    private List<postsResponse> posts;

    public List<postsResponse> getPosts() {
        return posts;
    }

    public void setPosts(List<postsResponse> posts) {
        this.posts = posts;
    }
}
