package com.yuandong.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private ImageView iv_pic;
    private MyAdapter adapter;
    String url = "http://p4.so.qhimg.com/t010c102c7b029340d4.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        iv_pic=(ImageView)findViewById(R.id.iv_pic);
        Glide.with(this)
                .load(url)
                .animate(R.anim.gilde_load_pic)
                .into(iv_pic);
        listView=(ListView) findViewById(R.id.listView);
        ArrayList<String> urls=new ArrayList<>();
        for(int i=0;i<10;i++){
            urls.add(url);
        }
        adapter=new MyAdapter(this,urls);
        listView.setAdapter(adapter);
    }

}
