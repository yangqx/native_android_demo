package com.example.helloworld2.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.helloworld2.R;

public class GridViwActivity extends AppCompatActivity {
    private GridView mGridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGridView = findViewById(R.id.gv);
        mGridView.setAdapter(new MyGridViewAdapter(GridViwActivity.this));
    }
}
