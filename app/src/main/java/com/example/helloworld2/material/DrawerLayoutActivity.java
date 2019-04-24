package com.example.helloworld2.material;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld2.R;

import java.util.ArrayList;

public class DrawerLayoutActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    private DrawerLayout drawerLayout;
    private ListView list_view;
    private ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        drawerLayout = findViewById(R.id.activity_drawer_layout);
        drawerLayout.addDrawerListener(this);
        list_view = findViewById(R.id.list_view);
        Toolbar toolBar = findViewById(R.id.toolBar);
        //设置toolbar 图标点击监听
        toolBar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //设置弹出侧拉栏
                drawerLayout.openDrawer(Gravity.LEFT);
            }

        });

        initData();
        list_view.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList));



    }

    private void initData() {
        dataList = new ArrayList<>();
        for (int i=0;i<100;i++){
            dataList.add("条目 "+i);
        }
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {

    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        Toast.makeText(this,"侧拉框打开",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {

        Toast.makeText(this,"侧拉框关闭",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerStateChanged(int i) {

    }
}
