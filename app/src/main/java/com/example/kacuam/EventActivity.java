package com.example.kacuam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.util.ToastUtil;

//通过事件源所在类实现,通过实现接口View.OnClickListener和方法
public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEvent;
    private Button mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        //内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
        //匿名内部类
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("匿名内部类","click.............");
                ToastUtil.shoeMsg(EventActivity.this,"click...");
            }
        });
        //通过事件源所在类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
        //通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

        mBtnMy = (Button) findViewById(R.id.btn_my);
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","-----onTouch-----");
                        break;
                }
                return false;   //一样true消费完停止传播
            }
        });
        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener","-----onClick-----");
            }
        });
        mBtnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;   //false会使前面setOnClickListener一样执行
            }
        });
    }

    //事件源所在类实现接口方法
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_event:
                ToastUtil.shoeMsg(EventActivity.this,"click...");
                break;
        }
    }

    //内部类
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_event:
                    Log.d("内部类","click.............");
                    ToastUtil.shoeMsg(EventActivity.this,"click...");
                    break;
            }
        }
    }

    //布局文件中onClick属性（针对点击事件）
    public void show(View v){
        switch(v.getId()){
            case R.id.btn_event:
                Log.d("布局","click.............");
                ToastUtil.shoeMsg(EventActivity.this,"click'''");
                break;
        }
    }

    //回调机制
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","-----onTouchEvent-----");
                break;
        }
        return false;
    }
}
