package com.example.helloworld2.material.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloworld2.R;
import com.example.helloworld2.material.viewHolder.SimpleViewHolder;

import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private final Context context;
    private final ArrayList<String> dataList;

    public SimpleAdapter(Context context, ArrayList<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    //创建viewHolder 并设置viewHolder的布局效果
    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //将布局转化为view
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item,viewGroup,false);
        //创建viewHolder
        SimpleViewHolder simpleViewHolder = new SimpleViewHolder(view);
        return simpleViewHolder;
    }

    //要给条目空间展示的数据
    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int i) {
        simpleViewHolder.textView.setText(dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
