package com.example.kacuam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kacuam.gridview.GridViewActivity;
import com.example.kacuam.listview.ListViewActivity;
import com.example.kacuam.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGirdView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = (Button) findViewById(R.id.btn_textview);
        mBtnButton = (Button) findViewById(R.id.btn_botton);
        mBtnEditText = (Button) findViewById(R.id.btn_edittext);
        mBtnRadioButton = (Button) findViewById(R.id.btn_radiobutoon);
        mBtnCheckBox = (Button) findViewById(R.id.btn_checkbox);
        mBtnImageView = (Button) findViewById(R.id.btn_imageview);
        mBtnListView = (Button) findViewById(R.id.btn_listview);
        mBtnGirdView = (Button) findViewById(R.id.btn_gridview);
        mBtnRecyclerView = (Button) findViewById(R.id.btn_recyclerview);
        mBtnWebView = (Button) findViewById(R.id.btn_webview);
        mBtnToast = (Button) findViewById(R.id.btn_toast);
        mBtnDialog = (Button) findViewById(R.id.btn_dialog);
        mBtnProgress = (Button) findViewById(R.id.btn_progress);
        mBtnCustomDialog = (Button) findViewById(R.id.btn_customdialog);
        mBtnPopupWindow = (Button) findViewById(R.id.btn_popupwindow);
        setListeners();
    }

    private void setListeners(){
        OnClick onclick = new OnClick();
        mBtnTextView.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnTextView.setOnClickListener(onclick);
        mBtnRadioButton.setOnClickListener(onclick);
        mBtnCheckBox.setOnClickListener(onclick);
        mBtnImageView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
        mBtnGirdView.setOnClickListener(onclick);
        mBtnRecyclerView.setOnClickListener(onclick);
        mBtnWebView.setOnClickListener(onclick);
        mBtnToast.setOnClickListener(onclick);
        mBtnDialog.setOnClickListener(onclick);
        mBtnProgress.setOnClickListener(onclick);
        mBtnCustomDialog.setOnClickListener(onclick);
        mBtnPopupWindow.setOnClickListener(onclick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch(v.getId()){
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this,TextViewActivity.class);
                    break;
                case  R.id.btn_botton:
                    intent = new Intent(UIActivity.this,ButtonActivity.class);
                    break;
                case  R.id.btn_edittext:
                    intent = new Intent(UIActivity.this,EditTextActivity.class);
                    break;
                case  R.id.btn_radiobutoon:
                    intent = new Intent(UIActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UIActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_customdialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_popupwindow:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
