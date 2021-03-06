package com.appbusters.robinkamboj.zailetapp.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appbusters.robinkamboj.zailetapp.R;
import com.appbusters.robinkamboj.zailetapp.model.postsResponse;
import com.appbusters.robinkamboj.zailetapp.view.holders.PostsHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

public class PostsAdapter extends RecyclerView.Adapter<PostsHolder>{

    private List<postsResponse> list = new ArrayList<>();
    private Context context, parentContext;
    private List<Boolean> isFollowing = new ArrayList<>();

    public PostsAdapter(List<postsResponse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public PostsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_post, parent, false);
        for(int i = 0; i<=list.size(); i++){
            isFollowing.add(false);
        }
        return new PostsHolder(v);
    }

    @Override
    public void onBindViewHolder(final PostsHolder holder, final int position) {
        holder.author.setText(list.get(position).getAuthor_info().getName());
        holder.postTitle.setText(list.get(position).getPost_info().getTitle());
        holder.time.setText(list.get(position).getPost_info().getTime());
        holder.postDescription.setText(list.get(position).getPost_info().getDescription());
        String postCover = "http://zailet.com/" + list.get(position).getPost_info().getCover();
        Glide.with(parentContext)
                .load(postCover)
                .bitmapTransform(new BrightnessFilterTransformation(parentContext, -0.3f))
                .into(holder.postCover);
        String authorCover = "http://zailet.com/" + list.get(position).getAuthor_info().getDp();
        Glide.with(parentContext)
                .load(authorCover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.circleImageView);

        if(isFollowing.get(position) && !holder.likeButton.isLiked()){
            holder.likeButton.setLiked(true);
        }
        if(!isFollowing.get(position) && holder.likeButton.isLiked()){
            holder.likeButton.setLiked(false);
        }

        holder.likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                isFollowing.set(position, true);
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                isFollowing.set(position, false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
