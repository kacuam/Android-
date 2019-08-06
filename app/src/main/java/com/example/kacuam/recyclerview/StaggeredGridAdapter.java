package com.example.kacuam.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kacuam.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mcontext;
    private OnItemClickListenner mlistenner;

    public StaggeredGridAdapter(Context context, OnItemClickListenner listenner){
        this.mcontext = context;
        this.mlistenner = listenner;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_staggered_grid_recyclerview_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder viewHolder, final int i) {
        if(i % 2 != 0){
            viewHolder.imageView.setImageResource(R.drawable.image1);
        }else{
            viewHolder.imageView.setImageResource(R.drawable.image2);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistenner.onClick(i);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mcontext, "long click "+i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListenner{
        void onClick(int pos);
    }
}
