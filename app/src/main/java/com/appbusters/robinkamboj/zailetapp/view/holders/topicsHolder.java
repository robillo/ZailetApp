package com.appbusters.robinkamboj.zailetapp.view.holders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbusters.robinkamboj.zailetapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class topicsHolder extends RecyclerView.ViewHolder{

    private Context context;

    public CircleImageView topicImage;
    public TextView topic;
    public TextView select;
    public CardView cardView;

    public topicsHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        topicImage = (CircleImageView) itemView.findViewById(R.id.topic_imageview);
        topic = (TextView) itemView.findViewById(R.id.topic);
        select = (TextView) itemView.findViewById(R.id.select);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }
}
