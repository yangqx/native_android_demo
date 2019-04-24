package com.example.helloworld2.material.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloworld2.R;
import com.example.helloworld2.material.listener.ItemTouchListener;
import com.example.helloworld2.material.listener.OnItemClickLListener;
import com.example.helloworld2.material.viewHolder.SimpleViewHolder;

import java.util.ArrayList;
import java.util.Collections;

public class ItemAnimatorAdapter extends RecyclerView.Adapter<SimpleViewHolder> implements ItemTouchListener {

    private final Context context;
    private final ArrayList<String> dataList;
    ArrayList<Integer> heightList = new ArrayList<>();
    private OnItemClickLListener onItemClickListener ;

    public ItemAnimatorAdapter(Context context, ArrayList<String> dataList){
        this.context = context;
        this.dataList = dataList;
        for(int i=0;i<100;i++){
            heightList.add((int) (100+Math.random()*200));
        }
    }

    //接口回调的方式
    public void setOnItemClickListener(OnItemClickLListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
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

    //要给条目控件展示的数据
    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, final int i) {

        //设置当前控件的高度
        final ViewGroup.LayoutParams layoutParams = simpleViewHolder.textView.getLayoutParams();
        layoutParams.height = heightList.get(i);
        //重新设置布局参数
        simpleViewHolder.textView.setLayoutParams(layoutParams);
        simpleViewHolder.textView.setBackgroundColor(
                Color.rgb((int) (100+Math.random()*155),(int) (100+Math.random()*155),(int) (100+Math.random()*155))
                );
        simpleViewHolder.textView.setText(dataList.get(i));

        simpleViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //条目点击了
                onItemClickListener.onItemClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 交换条目的位置
     * @param oldPosition
     * @param newPosition
     */
    @Override
    public void onMove(int oldPosition, int newPosition) {
        Collections.swap(dataList,oldPosition,newPosition);
        //刷新一下适配器
        notifyItemMoved(oldPosition,newPosition);
    }

    @Override
    public void onSwiped(int position) {
        //删除
        dataList.remove(position);
        notifyItemRemoved(position);
    }
}
