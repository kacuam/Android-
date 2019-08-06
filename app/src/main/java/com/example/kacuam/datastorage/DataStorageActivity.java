package com.example.kacuam.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.R;
import com.example.kacuam.fragment.BFragment;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedpeferences,mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedpeferences = (Button) findViewById(R.id.btn_sharedpeferences);
        mBtnFile = (Button) findViewById(R.id.btn_file);
        mBtnSharedpeferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_sharedpeferences:
                intent = new Intent(DataStorageActivity.this,SharedpeferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this,FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
