package com.appbusters.robinkamboj.zailetapp.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.zailetapp.R;
import com.appbusters.robinkamboj.zailetapp.model.postsResponse;
import com.appbusters.robinkamboj.zailetapp.view.holders.PostsHolder;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsHolder>{

    private List<postsResponse> list = new ArrayList<>();
    private Context context, parentContext;

    public PostsAdapter(List<postsResponse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public PostsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_post, parent, false);
        return new PostsHolder(v);
    }

    @Override
    public void onBindViewHolder(PostsHolder holder, int position) {
        holder.author.setText(list.get(position).getAuthor_info().getName());
        holder.postTitle.setText(list.get(position).getPost_info().getTitle());
        holder.time.setText(list.get(position).getPost_info().getTime());
        holder.postDescription.setText(list.get(position).getPost_info().getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
