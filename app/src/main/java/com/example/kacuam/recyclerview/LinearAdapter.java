package com.example.kacuam.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kacuam.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mcontext;
    private OnItemClickListenner mlistenner;

    public LinearAdapter(Context context,OnItemClickListenner listenner){
        this.mcontext = context;
        this.mlistenner = listenner;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == 0){
            return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item,viewGroup,false));
        }else{
            return new LinearViewHolder2(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item_2,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (getItemViewType(i ) == 0){
            ((LinearViewHolder)viewHolder).textView.setText("Hello World!");
        }else{
            ((LinearViewHolder2)viewHolder).textView.setText("又有bug");
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
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }
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

    class LinearViewHolder2 extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;


        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListenner{
        void onClick(int pos);
    }
}
