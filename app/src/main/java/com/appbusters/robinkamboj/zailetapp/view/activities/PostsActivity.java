package com.appbusters.robinkamboj.zailetapp.view.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.appbusters.robinkamboj.zailetapp.R;
import com.appbusters.robinkamboj.zailetapp.model.postsResponse;
import com.appbusters.robinkamboj.zailetapp.model.postsResponseResponse;
import com.appbusters.robinkamboj.zailetapp.model.topics;
import com.appbusters.robinkamboj.zailetapp.model.topicsResponse;
import com.appbusters.robinkamboj.zailetapp.rest.ApiClient;
import com.appbusters.robinkamboj.zailetapp.rest.ApiInterface;
import com.appbusters.robinkamboj.zailetapp.view.adapters.PostsAdapter;
import com.appbusters.robinkamboj.zailetapp.view.adapters.TopicsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout alternateLayout, recyclerLayout;
    private List<postsResponse> list = new ArrayList<>();
    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        alternateLayout = (LinearLayout) findViewById(R.id.layout_alternate);
        recyclerLayout = (LinearLayout) findViewById(R.id.rv_layout);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        selectedItems = getIntent().getStringArrayListExtra("selectedItems");
//        Log.e("SIZE", " " + selectedItems.size());
//        for(int i=0; i<selectedItems.size(); i++){
//            Log.e("SELECTED", selectedItems.get(i));
//        }

        callPosts();
    }

    public void callPosts() {
        Call<postsResponseResponse> call = apiInterface.getPosts(1);

        if (call != null) {
            call.enqueue(new Callback<postsResponseResponse>() {
                @Override
                public void onResponse(Call<postsResponseResponse> call, Response<postsResponseResponse> response) {
                    for (postsResponse post : response.body().getPosts()) {
                        list.add(post);
                        Log.e("author is ", post.getAuthor_info().getName());
                        Log.e("post is ", post.getPost_info().getTitle());
                    }
                    if (list.size() > 1) {
                        Log.e("RV SET?", "ADAPTER SET, TRUE");
                        alternateLayout.setVisibility(View.GONE);
                        recyclerLayout.setVisibility(View.VISIBLE);
                        adapter = new PostsAdapter(list, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<postsResponseResponse> call, Throwable t) {
                    Snackbar.make(coordinatorLayout, "Please make sure you are connected to internet.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    callPosts();
                                }
                            }).show();
                }
            });
        }
    }
}
