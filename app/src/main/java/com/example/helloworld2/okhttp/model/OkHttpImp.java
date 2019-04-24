package com.example.helloworld2.okhttp.model;

import android.os.Message;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpImp implements HttpInterface {

    private final OkHttpClient okHttpClient;
    private final HttpCallback callback;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType MEDIA = MediaType.parse("application/octet-stream");
    //public static final MediaType MEDIA = MediaType.parse("image/jpeg");

    public  OkHttpImp(HttpCallback callback){
        okHttpClient = new OkHttpClient();
        this.callback = callback;
    }

    @Override
    public void sendGet(String url, Map<String, String> map, Class clazz,int what) {
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new OkHttpCallBack(clazz,callback));
    }

    @Override
    public void sendPost(String url, Map<String, String> map, Class clazz,int what) {
//        RequestBody body = RequestBody.create(JSON,"{\"aaa\":1,\"bbb\":2}");

        FormBody.Builder builder = new FormBody.Builder();
        for(String key:map.keySet()){
            Object o = map.get(key);
            builder.add(key,String.valueOf(o));
        }
//
        RequestBody body = builder.build();
        Request  request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new OkHttpCallBack(clazz,callback));
    }

    @Override
    public void sendJsonPost(String url, Class clazzRequest, Class clazzResponse,int what) {
        String string = com.alibaba.fastjson.JSON.toJSONString(clazzRequest);
        RequestBody body = RequestBody.create(JSON,string);
        Request  request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new OkHttpCallBack(clazzResponse,callback));
    }

    @Override
    public void uploadPic(String url, String localPath,Class resposeClazz,int what) {
        File file = new File(url);
        RequestBody body = new MultipartBody.Builder().addFormDataPart("file",file.getName(),RequestBody.create(MEDIA,file))
                .build();
        Request request = new Request.Builder().url("").post(body).build();
        Call call  = okHttpClient.newCall(request);
    }
}
