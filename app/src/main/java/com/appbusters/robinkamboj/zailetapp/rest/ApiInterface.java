package com.appbusters.robinkamboj.zailetapp.rest;

import com.appbusters.robinkamboj.zailetapp.model.postsResponseResponse;
import com.appbusters.robinkamboj.zailetapp.model.topicsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //First Page Results

    @GET("get_data.php")
    Call<topicsResponse> getTopics(@Query("get_topics") int page);

    @GET("get_data.php")
    Call<postsResponseResponse> getPostsByID(@Query("topics_info") int page, @Query("id") int id);

}
