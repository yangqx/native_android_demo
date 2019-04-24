package com.example.helloworld2.material;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.helloworld2.R;
import com.example.helloworld2.material.adapter.SimpleAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> dataList;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        recyclerView = findViewById(R.id.recyclerView);
        initData();
        //设置布局管理者
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        simpleAdapter = new SimpleAdapter(this,dataList);
                //设置数据适配器
        recyclerView.setAdapter(simpleAdapter);
    }

    private void initData() {
        dataList = new ArrayList<String>();
        for (int i=0; i<100; i++){
            dataList.add("条目 "+i);
        }
    }


    public void singleVertical(View view) {
        //设置布局管理者
        //设置横向排列
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        simpleAdapter.notifyDataSetChanged();
    }

    public void moreVertical(View view) {
        //设置布局管理者
        //设置横向排列
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3,RecyclerView.VERTICAL, false));
        simpleAdapter.notifyDataSetChanged();
    }

    public void singleHorizontal(View view) {
        //设置布局管理者
        //设置横向排列
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        simpleAdapter.notifyDataSetChanged();
    }

    public void moreHorizontal(View view) {
        //设置布局管理者
        //设置横向排列
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3,RecyclerView.HORIZONTAL, false));
        simpleAdapter.notifyDataSetChanged();
        //
    }
}
