package com.example.helloworld2.netease.okhttp;

import java.net.HttpURLConnection;

public class JsonHttpRequest implements IHttpRequest {

    private String url;
    private byte[] data;
    private CallBackListener mCallBackListener;
    private HttpURLConnection urlConnection;

    @Override
    public void setUrl(String url) {
        this.url = url;

    }

    @Override
    public void setData(byte[] data) {

        this.data = data;
    }

    @Override
    public void setListener(CallBackListener listener) {
        this.mCallBackListener = listener;
    }

    @Override
    public void execute() {

        //请求访问
    }
}
