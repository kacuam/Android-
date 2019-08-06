package com.example.kacuam;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kacuam.recyclerview.LinearAdapter;
import com.example.kacuam.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = (Button) findViewById(R.id.btn_style1);
        mBtnDialog2 = (Button) findViewById(R.id.btn_style2);
        mBtnDialog3 = (Button) findViewById(R.id.btn_style3);
        mBtnDialog4 = (Button) findViewById(R.id.btn_style4);
        mBtnDialog5 = (Button) findViewById(R.id.btn_style5);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_style1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("回答")
                            .setMessage("你是不是傻子")
                            .setIcon(R.drawable.username)
                            .setPositiveButton("是的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.shoeMsg(DialogActivity.this,"牛皮");
                        }
                    }).setNeutralButton("呵呵", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.shoeMsg(DialogActivity.this,"牛皮啊");
                        }
                    }).setNegativeButton("不是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.shoeMsg(DialogActivity.this,"更牛皮");
                        }
                    }).show();
                    break;
                case R.id.btn_style2:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.shoeMsg(DialogActivity.this,array2[which]);

                        }
                    }).show();
                    break;
                case R.id.btn_style3:
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("性别")
                            .setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.shoeMsg(DialogActivity.this,array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_style4:
                    final String[] array4 = new String[]{"玩吉他","绘画","玩滑板"};
                    boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    ToastUtil.shoeMsg(DialogActivity.this,array4[which] + ":" + isChecked);
                                }
                            }
                    ).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_style5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText etusername = (EditText) view.findViewById(R.id.et_username);
                    EditText etpassword = (EditText) view.findViewById(R.id.et_password);
                    Button btlogin = (Button) view.findViewById(R.id.btn_login);
                    btlogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.shoeMsg(DialogActivity.this,"登录成功");
                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }
}
