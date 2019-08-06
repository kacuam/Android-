package com.example.kacuam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.util.ToastUtil;

public class LifeCycleActivity extends AppCompatActivity {

    private Button mBtnOnResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnOnResume = (Button) findViewById(R.id.btn_resume);
        mBtnOnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });
        Log.d("LifeCycle","-----onCreate-----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","-----onStart-----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","-----onResume-----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","-----onPause-----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","-----onStop-----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","-----onRestart-----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","-----onDestroy-----");
    }
}
