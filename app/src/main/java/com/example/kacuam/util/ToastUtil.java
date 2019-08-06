package com.example.kacuam.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mToast;
    public static void  shoeMsg(Context context,String msg){
        if(mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
