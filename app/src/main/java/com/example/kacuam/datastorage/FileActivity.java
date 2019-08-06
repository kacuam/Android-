package com.example.kacuam.datastorage;


import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kacuam.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;
    private final String mFileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpeferences);
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });
    }

    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(),"kacuam");
            if (!dir.exists()){
                dir.mkdirs();
            }
            //创建文件
            File file = new File(dir,mFileName);
            if (!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
//            fileInputStream = openFileInput(mFileName);
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"kacuam",mFileName);
            fileInputStream = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            int len = 0;
            byte[] buff = new byte[1024*8];
            while ((len = fileInputStream.read(buff)) != -1){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
