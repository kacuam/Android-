package com.example.kacuam.recyclerview;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.R;
import com.example.kacuam.gridview.GridViewActivity;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear,mBtmHor,mBtnGrid,mBtnPu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mBtnLinear = (Button) findViewById(R.id.btn_linear);
        mBtmHor = (Button) findViewById(R.id.btn_hor);
        mBtnGrid = (Button) findViewById(R.id.btn_grid);
        mBtnPu = (Button) findViewById(R.id.btn_pu);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtmHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
