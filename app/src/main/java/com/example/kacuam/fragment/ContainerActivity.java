package com.example.kacuam.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.kacuam.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick{

    private AFragment aFragment;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvTitle = (TextView) findViewById(R.id.tv_title);

        //实例化AFragment
//        aFragment = new AFragment();
        aFragment = AFragment.newInstance("我是参数");
        //把AFragment添加到Activity中,记得调用commit
//        getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
        Log.e("myaaaaafragmenr","111111111111111111");
    }

    public void setData(String text){
        mTvTitle.setText(text);
    }

    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}
