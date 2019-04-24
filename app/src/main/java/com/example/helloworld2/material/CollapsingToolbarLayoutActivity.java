package com.example.helloworld2.material;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.helloworld2.R;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolBarLayout);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        collapsingToolbarLayout.setTitle();
//        collapsingToolbarLayout.setCollapsedTitleTextColor();
//

    }
}
