package com.example.helloworld2.netease.okhttp;

import java.io.InputStream;

public class JsonCallBackListener<T> implements CallBackListener {

    private Class<T> responseClass;

    public JsonCallBackListener(Class<T> responseClass) {
        this.responseClass = responseClass;
    }

    @Override
    public void onSuccess(InputStream inputStream) {

        //将inputstream转换为responseClass

    }

    @Override
    public void onFailture() {

    }
}
