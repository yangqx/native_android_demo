package com.example.helloworld2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.helloworld2.material.CardViewActivity;
import com.example.helloworld2.material.CollapsingToolbarLayoutActivity;
import com.example.helloworld2.material.CoordinatorLayoutActivity;
import com.example.helloworld2.material.DrawerLayoutActivity;
import com.example.helloworld2.material.FiveActivity;
import com.example.helloworld2.material.FouthActivity;
import com.example.helloworld2.material.FristActivity;
import com.example.helloworld2.material.SecondActivity;
import com.example.helloworld2.material.SixActivity;
import com.example.helloworld2.material.SnackBarActivity;
import com.example.helloworld2.material.TabLayoutActivity;
import com.example.helloworld2.material.TextInputActivity;
import com.example.helloworld2.material.ThirdActivity;
import com.example.helloworld2.material.ToolBarActivity;

import java.util.ArrayList;


public class MaterialDesignActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
        ListView listView = findViewById(R.id.list_view);
        initdata();
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList));
        listView.setOnItemClickListener(this);

    }

    private void initdata() {
        dataList = new ArrayList<>();
        //0
        dataList.add("单行 多行 单横 多横");
        dataList.add("添加下划线");
        dataList.add("瀑布流效果 条目动画");
        dataList.add("多条目效果展示");
        dataList.add("条目拖动删除效果");
        dataList.add("下拉刷新上拉加载");
        //7
        dataList.add("CartView展示效果");
        dataList.add("TabLayout展示效果");
        dataList.add("ToolBar展示效果");
        //10
        dataList.add("DrawerLayout展示效果");
        //11
        dataList.add("TextInputLayout展示效果");
        //12
        dataList.add("CoordinatorLayout 协调效果");
        //13
        dataList.add("SnackBar 提示 效果");
        //14
        dataList.add("CollapsingToolbarLayout 提示 效果");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                enterActivity(FristActivity.class);
                break;
            case 1:
                enterActivity(SecondActivity.class);
                break;
            case 2:
                enterActivity(ThirdActivity.class);
                break;
            case 3:
                enterActivity(FouthActivity.class);
                break;
            case 4:
                enterActivity(FiveActivity.class);
                break;
            case 5:
                enterActivity(SixActivity.class);
                break;
            case 6:
                enterActivity(CardViewActivity.class);
                break;
            case 7:
                enterActivity(TabLayoutActivity.class);
                break;
            case 8:
                enterActivity(ToolBarActivity.class);
                break;
            case 9:
                enterActivity(DrawerLayoutActivity.class);
                break;
            case 10:
                enterActivity(TextInputActivity.class);
                break;
            case 11:
                enterActivity(CoordinatorLayoutActivity.class);
                break;
            case 12:
                enterActivity(SnackBarActivity.class);
                break;
            case 13:
                enterActivity(CollapsingToolbarLayoutActivity.class);
                break;

        }
    }

    public void enterActivity(Class clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}
