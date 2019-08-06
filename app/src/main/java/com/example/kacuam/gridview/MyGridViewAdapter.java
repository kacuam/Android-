package com.example.kacuam.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kacuam.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mlayoutInflater;

    public MyGridViewAdapter(Context context){
        this.mcontext = context;
        mlayoutInflater = LayoutInflater.from(mcontext);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mlayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //赋值
        holder.textView.setText("花");
        Glide.with(mcontext).load("http://imglf4.nosdn.127.net/img/Q3hhWExLY0NPUTd5dlcySXErZk9zTllEenZCQWZlT3dsZThjeGFNZ0M1Z1Eza1ArRExXL1VBPT0.jpg?imageView&thumbnail=1972y2956&type=jpg&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZuA6ICB6YWlIC8gbWFxdWVzdS5sb2Z0ZXIuY29t&fon").into(holder.imageView);
        return convertView;
    }
}
