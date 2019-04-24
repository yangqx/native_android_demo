package com.example.helloworld2.material;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.helloworld2.R;
import com.example.helloworld2.material.fragment.NewsFragment;

public class TabLayoutActivity extends AppCompatActivity {
    String [] datas = {"新闻","推荐","体育","头条","八卦","视频","本地","美女","汽车","房产"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        //关联viewPager 自动刷新
        tabLayout.setupWithViewPager(viewPager,true);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return NewsFragment.getInstance(datas[i]);
            }

            @Override
            public int getCount() {
                return datas.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return datas[position];
            }
        });

    }
}
