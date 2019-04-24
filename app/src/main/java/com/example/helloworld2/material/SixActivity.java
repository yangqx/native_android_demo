package com.example.helloworld2.material;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld2.R;
import com.example.helloworld2.material.adapter.WaterFallAdapter;
import com.example.helloworld2.material.listener.OnItemClickLListener;

import java.util.ArrayList;

public class SixActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<String> dataList;
    private WaterFallAdapter waterFallAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swiperRefreshLayout);

        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(this);

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
                Toast.makeText(SixActivity.this,position+"被点击了",Toast.LENGTH_SHORT).show();

            }
        });
        //设置数据适配器
        recyclerView.setAdapter(waterFallAdapter);

    }


    @Override
    public void onRefresh() {
        //正在刷新操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //添加数据  刷新适配器
                dataList.add(0,"我是新条目");
                waterFallAdapter.notifyDataSetChanged();
                //设置刷新完毕不再刷新
                swipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }
}
