package com.example.kacuam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = (ImageView) findViewById(R.id.iv_4);
        Glide.with(this).load("https://www.baidu.com/img/dong_962301698d83dc26fa8e7b38011d1705.gif").into(mIv4);
    }
}
