package com.example.kacuam.jump;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kacuam.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","-----onCreate-----");
        Log.d("Activity","taskid"+getTaskId()+" ,hash"+hashCode());
        logtaskName();
        mBtnJump = (Button) findViewById(R.id.bnt_jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "哈哈");
                bundle.putInt("number",25);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);
//                intent.putExtra(key,value);
//                intent.putExtras(Bundle);

                //显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.kacuam.jump.BActivity");
//                startActivity(intent);

                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.kacuam.jump.BActivity"));
//                startActivity(intent);

                //隐式
//                Intent intent = new Intent();
//                intent.setAction("com.example.test.BActivity");
//                startActivity(intent);
            }
        });
        mBtnJump2 = (Button) findViewById(R.id.bnt_jump_2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,data.getExtras().getString("title"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","-----onNewIntent-----");
        Log.d("Activity","taskid"+getTaskId()+" ,hash"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
