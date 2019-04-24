package com.example.helloworld2.material;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld2.R;

public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        //初始化控件
        Toolbar toolbar = findViewById(R.id.toolBar);
        //支持actionBar
//        setSupportActionBar(toolbar);

        //设置导航图标的监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToolBarActivity.this,"导航图标被点击了",Toast.LENGTH_SHORT).show();
            }
        });

        //关联菜单选项
        toolbar.inflateMenu(R.menu.toolbar_menu);
        //给菜单选项设置监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //判断当前选中的菜单选项
                int itemId = menuItem.getItemId();
                switch (itemId){
                    case R.id.item_about:
                        Toast.makeText(ToolBarActivity.this,"关于图标被点击了",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.item_notification:
                        Toast.makeText(ToolBarActivity.this,"通知图标被点击了",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.item_search:
                        Toast.makeText(ToolBarActivity.this,"搜索图标被点击了",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.item_setting:
                        Toast.makeText(ToolBarActivity.this,"设置图标被点击了",Toast.LENGTH_SHORT).show();

                        break;
                }
                return false;
            }
        });

    }
}
