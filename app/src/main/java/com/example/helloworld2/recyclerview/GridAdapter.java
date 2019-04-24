package com.example.helloworld2.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloworld2.R;

import java.util.List;

import static com.example.helloworld2.R.layout.layout_grid_item;
import static com.example.helloworld2.R.layout.layout_grid_recyclerview_item;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {

    private Context mConText;
    private OnItemClickListener mListener;
    List<String> list;

    public GridAdapter(Context context, OnItemClickListener listener){
        this.mConText = context;
        this.mListener = listener;
    }

    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(this.mConText).inflate(layout_grid_recyclerview_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder viewHolder, final int i)
    {
        viewHolder.textView.setText("Hello, world!");
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

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);

        }
    }

    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}
