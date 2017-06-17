package com.appbusters.robinkamboj.zailetapp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.appbusters.robinkamboj.zailetapp.R;

import java.util.ArrayList;

public class PostsActivity extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        selectedItems = getIntent().getStringArrayListExtra("selectedItems");
        Log.e("SIZE", " " + selectedItems.size());
    }
}
