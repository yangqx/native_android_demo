package com.example.helloworld2.okhttp.model;

import java.util.Map;

public interface HttpInterface {
    public void sendGet(String url, Map<String,String> map,Class clazz,int what);
    public void sendPost(String url, Map<String,String> map,Class clazz,int what);
    public void sendJsonPost(String url,Class clazzRequest,Class clazzResponse,int what);
    public void uploadPic(String url,String localPath,Class clazz,int what);
}
