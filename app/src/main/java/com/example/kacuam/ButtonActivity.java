package com.example.kacuam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button mBnt3;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBnt3 = (Button) findViewById(R.id.btn_3);
        mBnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "牛皮", Toast.LENGTH_SHORT).show();
            }
        });
        mTv1 = (TextView) findViewById(R.id.tv_1);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "皮牛", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToast(View view){
        Toast.makeText(this, "吐司", Toast.LENGTH_SHORT).show();
    }
}
