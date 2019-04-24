package com.example.helloworld2.material.callback;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.helloworld2.material.listener.ItemTouchListener;

public class ItemTouchCallBack extends ItemTouchHelper.Callback {

    private final ItemTouchListener itemTouchListener;

    public ItemTouchCallBack(ItemTouchListener itemTouchListener){
        this.itemTouchListener = itemTouchListener;
    }

    /**
     * 返回int 值，获取拖动和删除的类型
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        //设置拖动标记
        int dragFlag = ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        int swipedFlag = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        //做出相应的标记
        return makeMovementFlags(dragFlag,swipedFlag);
    }

    /**
     *
     * @param recyclerView
     * @param viewHolder  拖动之前的容器
     * @param viewHolder1 拖动之后的容器（目标容器）
     * @return
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {

        int oldPosition = viewHolder.getAdapterPosition();
        int newPosition = viewHolder1.getAdapterPosition();
        //准备交换位置
        itemTouchListener.onMove(oldPosition,newPosition);

        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //删除操作
        itemTouchListener.onSwiped(viewHolder.getAdapterPosition());

    }
}
