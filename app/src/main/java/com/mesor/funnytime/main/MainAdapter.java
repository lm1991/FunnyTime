package com.mesor.funnytime.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mesor.funnytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mesor on 2017/11/23.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    String[] urls = {
            "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=4c3b2306ba51f819e5280b09b2dd2098/8718367adab44aed5b5a1bc9b91c8701a18bfb83.jpg",
            "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=a6730bdcdf62853586edda62f8861cb3/e4dde71190ef76c69acc8a059716fdfaaf516785.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/54fbb2fb43166d222510e4874c2309f79052d2ba.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/c2cec3fdfc0392452b0c121c8d94a4c27d1e256c.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/b812c8fcc3cec3fddd5e33bfdf88d43f86942793.jpg"
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int height = 500;
        if(position % 5 == 2 || position % 5 == 3) height = 200;
        ViewGroup.LayoutParams layoutParams = holder.imageView.getLayoutParams();
        layoutParams.height = height;
        Glide.with(context).load(urls[position % 5]).into(holder.imageView).onLoadStarted(context.getDrawable(R.drawable.ic_launcher_background));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
