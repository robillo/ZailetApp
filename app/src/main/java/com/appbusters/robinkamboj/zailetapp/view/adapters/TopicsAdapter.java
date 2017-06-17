package com.appbusters.robinkamboj.zailetapp.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.zailetapp.R;
import com.appbusters.robinkamboj.zailetapp.model.topics;
import com.appbusters.robinkamboj.zailetapp.view.holders.topicsHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class TopicsAdapter extends RecyclerView.Adapter<topicsHolder>{

    private List<topics> list = new ArrayList<>();
    private Context context, parentContext;
    private List<Boolean> isFollowing = new ArrayList<>();
    public List<String> selectedInterests = new ArrayList<>();
    public ArrayList<Integer> selectedIDs = new ArrayList<>();

    public TopicsAdapter(List<topics> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public topicsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_topic, parent, false);
        for(int i = 0; i<=list.size(); i++){
            isFollowing.add(false);
        }
        return new topicsHolder(v);
    }

    @Override
    public void onBindViewHolder(final topicsHolder holder, final int position) {

        holder.topic.setText(list.get(position).getInterest());
        String url = "http://zailet.com/" + list.get(position).getCover();
        Log.e("URL " + position, url);
        Glide.with(parentContext).load(url).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.topicImage);

        if(!isFollowing.get(position) && holder.select.getText().equals(context.getString(R.string.selected))){
            holder.select.setText(context.getString(R.string.not_selected));
            holder.select.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        else if(isFollowing.get(position) && holder.select.getText().equals(context.getString(R.string.not_selected))){
            holder.select.setText(context.getString(R.string.selected));
            holder.select.setBackgroundColor(context.getResources().getColor(R.color.black));
        }

        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFollowing.get(position) && holder.select.getText().equals(context.getString(R.string.not_selected))){
                    isFollowing.set(position, true);
                    if(!selectedInterests.contains(list.get(position).getId())){
                        selectedInterests.add(list.get(position).getId());
                    }
                    holder.select.setText(context.getString(R.string.selected));
                    holder.select.setBackgroundColor(context.getResources().getColor(R.color.black));
                }
                else if(isFollowing.get(position) && holder.select.getText().equals(context.getString(R.string.selected))){
                    isFollowing.set(position, false);
                    if(selectedInterests.contains(list.get(position).getId())){
                        selectedInterests.remove(list.get(position).getId());
                    }
                    holder.select.setText(context.getString(R.string.not_selected));
                    holder.select.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
//                    holder.setFollowersCount(item.getFollowersCount());
                }else if(holder.select.getText().equals(context.getString(R.string.selected))){
                    isFollowing.set(position, false);
                    if(selectedInterests.contains(list.get(position).getId())){
                        selectedInterests.remove(list.get(position).getId());
                    }
                    holder.select.setText(context.getString(R.string.not_selected));
                    holder.select.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                }else{
                    isFollowing.set(position, true);
                    if(!selectedInterests.contains(list.get(position).getId())){
                        selectedInterests.add(list.get(position).getId());
                    }
                    holder.select.setText(context.getString(R.string.selected));
                    holder.select.setBackgroundColor(context.getResources().getColor(R.color.black));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
