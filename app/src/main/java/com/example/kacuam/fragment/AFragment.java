package com.example.kacuam.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kacuam.R;

public class AFragment extends Fragment {

    private TextView mTvTitle;
    private Button mBtnChange, mBtnReset,mBtnMessage;
    private BFragment bFragment;
    private IOnMessageClick listenner;

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();//写成Fragment，没有创建实例
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listenner = (IOnMessageClick) context;
        }catch(ClassCastException e){
            throw new ClassCastException("Activity必须实现IOMessageClick接口");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment","------onCreateView------");  //说明视图重新被创建
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = (Button) view.findViewById(R.id.btn_reset);
        mBtnMessage = (Button) view.findViewById(R.id.btn_message);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                //视图返回会重新创建，解决方法
                //replace会直接代替掉原来的View，可以先hide隐藏在add添加进来
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    //可无的这里
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("我是新文字");
            }
        });
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listenner.onClick("你好");
            }
        });
        //传来的值设置在mTvTitle里
        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }
        Log.e("myfragmenr", "111111111111111111");
    }

}
