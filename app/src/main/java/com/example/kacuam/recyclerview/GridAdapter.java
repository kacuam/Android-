package com.example.kacuam.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kacuam.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {

    private Context mcontext;
    private OnItemClickListenner mlistenner;

    public GridAdapter(Context context, OnItemClickListenner listenner){
        this.mcontext = context;
        this.mlistenner = listenner;
    }

    @NonNull
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_grid_recyclerview_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder viewHolder, final int i) {
        viewHolder.textView.setText("Hello World!");
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

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListenner{
        void onClick(int pos);
    }
}
