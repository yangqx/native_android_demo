package com.example.helloworld2.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld2.R;

import java.util.List;

import static com.example.helloworld2.R.layout.layout_staggered_grid_item;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mConText;
    private OnItemClickListener mListener;
    List<String> list;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener){
        this.mConText = context;
        this.mListener = listener;
    }

    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(this.mConText).inflate(layout_staggered_grid_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder( StaggeredGridAdapter.LinearViewHolder viewHolder, final int i)
    {
        if(i % 2 !=1){
            viewHolder.imageView.setImageResource(R.drawable.bg_checkbox_false);
        }else {
            viewHolder.imageView.setImageResource(R.drawable.bg_checkbox_true);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mListener.onClick(i);
//                Toast.makeText(mContext, "click..." + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);

        }
    }

    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}
