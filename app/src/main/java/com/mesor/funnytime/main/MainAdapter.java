package com.mesor.funnytime.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mesor.funnytime.R;
import com.mesor.funnytime.main.model.Media;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mesor on 2017/11/23.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private final OnMediaSelectListener onMediaSelectListener;
    private List<Media> list;

    private final int minHeight, maxHeight;

    public MainAdapter(Context context, OnMediaSelectListener onMediaSelectListener) {
        this.context = context;
        this.onMediaSelectListener = onMediaSelectListener;
        this.list = new ArrayList<>();
        int width = context.getResources().getDisplayMetrics().widthPixels >> 1;
        width -= 3 * context.getResources().getDisplayMetrics().density;
        minHeight = width;
        maxHeight = width << 1;
    }

    public void setContent(List<Media> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Media media = list.get(position);
        int height = media.getHeight() * minHeight / media.getWidth();
        if (height > maxHeight) height = maxHeight;
        else if (height < minHeight) height = minHeight;
        if (holder.height != height) {
            ViewGroup.LayoutParams layoutParams = holder.coverView.getLayoutParams();
            layoutParams.height = height;
        }
        holder.height = height;
        Glide.with(context).load(media.getCoverPath()).into(holder.coverView).onLoadStarted(context.getResources().getDrawable(R.drawable
                .ic_launcher_background));
        Glide.with(context).load(media.getAuthorAvatar()).into(holder.avatarView);
        holder.like.setText(String.valueOf(media.getLikeCount()));
        //TODO like icon
        holder.itemView.setOnClickListener(view -> {
            if(onMediaSelectListener == null) return;
            Media selectMedia = (Media) view.getTag();
            onMediaSelectListener.onSelect(selectMedia);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView coverView, avatarView;
        TextView like;
        int height = 0;

        public ViewHolder(View itemView) {
            super(itemView);
            coverView = itemView.findViewById(R.id.imageView);
            avatarView = itemView.findViewById(R.id.avatar);
            like = itemView.findViewById(R.id.like);
        }
    }

    interface OnMediaSelectListener {
        void onSelect(Media media);
    }
}
