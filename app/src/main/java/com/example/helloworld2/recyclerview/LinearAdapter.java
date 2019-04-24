package com.example.helloworld2.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld2.R;

import java.util.List;

import static com.example.helloworld2.R.layout.layout_linear_item;
import static com.example.helloworld2.R.layout.layout_linear_item2;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mConText;
    List<String> list;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mConText = context;
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    if(viewType == 0){
        return new LinearViewHolder(LayoutInflater.from(this.mConText).inflate(layout_linear_item,viewGroup,false));
    }else{
        return new LinearViewHolder2(LayoutInflater.from(this.mConText).inflate(layout_linear_item2,viewGroup,false));
    }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if(getItemViewType(i) == 0){
            ((LinearViewHolder)viewHolder).textView.setText("Hollo World!");

        }else {
            ((LinearViewHolder2)viewHolder).textView.setText("天哥在奔跑!");

        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Toast.makeText(mConText,"click..."+i ,Toast.LENGTH_SHORT).show();
                mListener.onClick(i);
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 ==0){
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
            imageView = itemView.findViewById(R.id.iv_image);

        }
    }

    public  interface OnItemClickListener{
        void onClick(int pos);
    }
}
