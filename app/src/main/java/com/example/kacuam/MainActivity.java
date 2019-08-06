package com.example.kacuam;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.datastorage.DataStorageActivity;
import com.example.kacuam.fragment.AFragment;
import com.example.kacuam.fragment.ContainerActivity;
import com.example.kacuam.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnTest,mBtnJump,mBtnFragment,mBtnEvent,mBtnHandler,mBtnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = (Button) findViewById(R.id.ui);
        mBtnTest = (Button) findViewById(R.id.test);
        mBtnJump = (Button) findViewById(R.id.jump);
        mBtnFragment = (Button) findViewById(R.id.btn_fragment);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnHandler = (Button) findViewById(R.id.btn_handler);
        mBtnData = (Button) findViewById(R.id.btn_data);

        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnTest.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnHandler.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.test:
                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.jump:
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_handler:
                    intent = new Intent(MainActivity.this, HandlerActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
