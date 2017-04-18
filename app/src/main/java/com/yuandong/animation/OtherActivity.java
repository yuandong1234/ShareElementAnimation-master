package com.yuandong.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG=OtherActivity.class.getSimpleName();
    private ImageView iv_pic;
    String internetUrl = "http://p4.so.qhimg.com/t010c102c7b029340d4.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        iv_pic = (ImageView) findViewById(R.id.iv_pic);
        iv_pic.setOnClickListener(this);
        Glide.with(this)
                .load(internetUrl)
                .animate(R.anim.gilde_load_pic)
                .into(iv_pic);
    }


    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
