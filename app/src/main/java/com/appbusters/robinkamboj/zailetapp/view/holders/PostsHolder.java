package com.appbusters.robinkamboj.zailetapp.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbusters.robinkamboj.zailetapp.R;
import com.like.LikeButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostsHolder extends RecyclerView.ViewHolder{

    public CircleImageView circleImageView;
    public TextView author, time, postTitle, postDescription;
    public ImageView postCover;
    public LikeButton likeButton;

    public PostsHolder(View itemView) {
        super(itemView);
        circleImageView = (CircleImageView) itemView.findViewById(R.id.circle_image);
        author = (TextView)  itemView.findViewById(R.id.author);
        time = (TextView) itemView.findViewById(R.id.time);
        postTitle = (TextView)  itemView.findViewById(R.id.post_title);
        postDescription = (TextView)  itemView.findViewById(R.id.post_description);
        postCover = (ImageView)  itemView.findViewById(R.id.post_cover);
        likeButton = (LikeButton) itemView.findViewById(R.id.star_button);
    }
}
