package com.example.helloworld2.material.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld2.R;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    public final TextView textView;

    //itemView 展示的条目view
    public SimpleViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_item);
    }
}
