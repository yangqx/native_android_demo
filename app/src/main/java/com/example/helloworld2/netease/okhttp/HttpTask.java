package com.example.helloworld2.netease.okhttp;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

public class HttpTask<T> implements Runnable {

    private IHttpRequest mIHttpRequest;
    public HttpTask(String url,T requestData,IHttpRequest httpRequest,CallBackListener listener){
        mIHttpRequest = httpRequest;
        httpRequest.setUrl(url);
        httpRequest.setListener(listener);
        String content = JSON.toJSONString(requestData);
        try {
            httpRequest.setData(content.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        mIHttpRequest.execute();
    }
}
