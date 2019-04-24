package com.example.helloworld2.okhttp.model;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpCallBack implements Callback {

    Class clazz;
    HttpCallback callback;
    public OkHttpCallBack(Class clazz,HttpCallback callback){
        this.clazz = clazz;
        this.callback = callback;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        callback.onError(e.toString());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String json = response.body().string();
        Object object = JSON.parseObject(json, clazz);
        callback.onSuccess(object);
    }
}
