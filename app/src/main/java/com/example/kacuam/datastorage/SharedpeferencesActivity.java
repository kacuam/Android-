package com.example.kacuam.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kacuam.R;

public class SharedpeferencesActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpeferences);
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name",mEtName.getText().toString());
                mEditor.apply();    //mEditor.commit();是同步存储的过程，apply是异步过程,多线程还是apply好
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(mSharedPreferences.getString("name",""));
            }
        });
    }
}
