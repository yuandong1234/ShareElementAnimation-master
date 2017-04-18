package com.yuandong.animation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by yuandong on 2017/4/18.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> urls;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<String> urls) {
        this.context = context;
        this.urls = urls;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (urls != null && urls.size() > 0) {
            return urls.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if(convertView==null){
            convertView =inflater.inflate(R.layout.layout_item,null);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
           vh=(ViewHolder)convertView.getTag();
        }
        Glide.with(context).load(urls.get(position)).into(vh.img);
        vh.ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,OtherActivity.class);
                if (android.os.Build.VERSION.SDK_INT > 20) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                            Pair.create((View)(vh.img), "transitionImg"),
                            Pair.create((View)(vh.tv), "transitionTv"));

                   context. startActivity(intent, options.toBundle());
                    //startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, iv_pic, "transitionImg").toBundle());
                } else {
                    context. startActivity(intent);
                }
            }
        });

        return convertView;
    }

    private class ViewHolder {
        LinearLayout ll_parent;
        ImageView img;
        TextView tv;
        public ViewHolder(View contentView) {
            ll_parent=(LinearLayout)contentView.findViewById(R.id.ll_parent);
            img = (ImageView) contentView.findViewById(R.id.iv_pic);
            tv = (TextView) contentView.findViewById(R.id.tv_title);
        }
    }
}
