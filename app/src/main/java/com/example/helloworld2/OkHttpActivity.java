package com.example.helloworld2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld2.okhttp.bean.FirstPageBean;
import com.example.helloworld2.okhttp.model.HttpCallback;
import com.example.helloworld2.okhttp.model.OkHttpImp;

import java.util.HashMap;
import java.util.Map;

public class OkHttpActivity extends AppCompatActivity implements HttpCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

    }

    @Override
    public void onSuccess(Object obj) {

        //根据what 来判断是哪个方法调用的
        System.out.println(obj.toString());
        //Toast.makeText(this,obj.toString(),Toast.LENGTH_SHORT).show();
        Log.d("onSuccess",obj.toString());
    }

    @Override
    public void onError(Object obj) {

    }

    public void postTest(View view) {
        //http://www.tfjyzx.com/school/navigation
        OkHttpImp okHttpImp = new OkHttpImp(this);
        Map map = new HashMap<String,String>();
        map.put("area","");
        //okHttpImp.sendPost("http://www.tfjyzx.com/school/navigation",map, FirstPageBean.class,1);
        //okHttpImp.sendGet("http://www.tfjyzx.com/school/navigation",map, FirstPageBean.class,1);

    }

    public void getTest(View view) {
        //推荐让 OkHttpClient 保持单例 ,此处没有使用单例
        OkHttpImp okHttpImp = new OkHttpImp(this);
        Map map = new HashMap<String,String>();
        map.put("area","");
        //okHttpImp.sendPost("http://www.tfjyzx.com/school/navigation",map, FirstPageBean.class,1);
        okHttpImp.sendGet("http://www.tfjyzx.com/school/navigation",map, FirstPageBean.class,1);

    }
}
