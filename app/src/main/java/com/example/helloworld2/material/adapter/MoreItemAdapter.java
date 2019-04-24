package com.example.helloworld2.material.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloworld2.R;
import com.example.helloworld2.material.viewHolder.FirstTypeHolder;
import com.example.helloworld2.material.viewHolder.SecondTypeHolder;
import com.example.helloworld2.material.viewHolder.ThirdTypeHolder;

public class MoreItemAdapter extends RecyclerView.Adapter {

    public static final int TYPE_FIRST = 0;
    public static final int TYPE_SECOND = 1;
    public static final int TYPE_THIRD = 2;
    public Context context;

    public MoreItemAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        //根据不同的类型创建不同的ViewHolder
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        switch (viewType){
            case TYPE_FIRST:
                view =  LayoutInflater.from(context).inflate(R.layout.type_first_layout,viewGroup,false);
                viewHolder = new FirstTypeHolder(view);
                break;
            case TYPE_SECOND:
                view =  LayoutInflater.from(context).inflate(R.layout.type_second_layout,viewGroup,false);
                viewHolder = new SecondTypeHolder(view);
                break;
            case TYPE_THIRD:
                view =  LayoutInflater.from(context).inflate(R.layout.type_third_layout,viewGroup,false);
                viewHolder = new ThirdTypeHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        //获取当前条目类型
        //
    }

    /**
     * 获取条目类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return  TYPE_FIRST;
        }
        if(position == 1){
            return  TYPE_SECOND;
        }
        if(position == 2){
            return  TYPE_THIRD;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
