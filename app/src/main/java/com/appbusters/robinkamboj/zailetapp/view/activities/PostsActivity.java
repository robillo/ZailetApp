package com.appbusters.robinkamboj.zailetapp.view.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.appbusters.robinkamboj.zailetapp.R;
import com.appbusters.robinkamboj.zailetapp.rest.ApiClient;
import com.appbusters.robinkamboj.zailetapp.rest.ApiInterface;
import com.appbusters.robinkamboj.zailetapp.view.adapters.TopicsAdapter;

import java.util.ArrayList;

public class PostsActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    ArrayList<String> selectedItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout alternateLayout, recyclerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        alternateLayout = (LinearLayout) findViewById(R.id.layout_alternate);
        recyclerLayout = (LinearLayout) findViewById(R.id.rv_layout);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        selectedItems = getIntent().getStringArrayListExtra("selectedItems");
        Log.e("SIZE", " " + selectedItems.size());
        for(int i=0; i<selectedItems.size(); i++){
            Log.e("SELECTED", selectedItems.get(i));
        }
    }
}
