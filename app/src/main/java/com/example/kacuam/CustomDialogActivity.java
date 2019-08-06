package com.example.kacuam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.util.ToastUtil;
import com.example.kacuam.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog = (Button) findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项？")
                .setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.shoeMsg(CustomDialogActivity.this,"为什么呢");
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        ToastUtil.shoeMsg(CustomDialogActivity.this,"好");
                    }
                }).show();
            }
        });
    }
}
