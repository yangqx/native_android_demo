package com.example.helloworld2.material;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld2.R;
import com.example.helloworld2.material.adapter.WaterFallAdapter;
import com.example.helloworld2.material.listener.OnItemClickLListener;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private ArrayList<String> dataList;
    private WaterFallAdapter waterFallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //设置布局管理者
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));

//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataList = new ArrayList<>();
        for (int i=0; i<100;i++){
            dataList.add("条目"+i);
        }
        waterFallAdapter = new WaterFallAdapter(this, dataList);

        //对适配器设置监听 使用接口回调的方式
        waterFallAdapter.setOnItemClickListener(new OnItemClickLListener(){

            @Override
            public void onItemClick(int position) {
                Toast.makeText(ThirdActivity.this,position+"被点击了",Toast.LENGTH_SHORT).show();

            }
        });
        //设置数据适配器
        recyclerView.setAdapter(waterFallAdapter);

    }


    public void addItem(View view) {
        dataList.add(2,"哈哈");
        //单条目刷新
        waterFallAdapter.notifyItemInserted(2);
    }

    public void deleteItem(View view) {

        dataList.remove(4);
        //单条删除
        waterFallAdapter.notifyItemRemoved(4);
    }
}
