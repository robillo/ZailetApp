package com.appbusters.robinkamboj.zailetapp;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.appbusters.robinkamboj.zailetapp.model.topics;
import com.appbusters.robinkamboj.zailetapp.model.topicsResponse;
import com.appbusters.robinkamboj.zailetapp.rest.ApiClient;
import com.appbusters.robinkamboj.zailetapp.rest.ApiInterface;
import com.appbusters.robinkamboj.zailetapp.view.adapters.TopicsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private List<topics> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private TopicsAdapter adapter;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout alternateLayout, recyclerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        alternateLayout = (LinearLayout) findViewById(R.id.layout_alternate);
        recyclerLayout = (LinearLayout) findViewById(R.id.rv_layout);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        callTopics();
    }

    private void callTopics(){
        Call<topicsResponse> call = apiInterface.getTopics(1);

        if(call!=null){
            call.enqueue(new Callback<topicsResponse>() {
                @Override
                public void onResponse(Call<topicsResponse> call, Response<topicsResponse> response) {
                    for(topics topic : response.body().getResult()){
                        list.add(topic);
                        Log.e("topic is ", topic.getInterest());
                    }
                    if(list.size()>1){
                        Log.e("RV SET?", "ADAPTER SET, TRUE");
                        alternateLayout.setVisibility(View.GONE);
                        recyclerLayout.setVisibility(View.VISIBLE);
                        adapter = new TopicsAdapter(list, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<topicsResponse> call, Throwable t) {
                    Snackbar.make(coordinatorLayout, "Please make sure you are connected to internet.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    callTopics();
                                }
                            }).show();
                }
            });
        }
    }
}
