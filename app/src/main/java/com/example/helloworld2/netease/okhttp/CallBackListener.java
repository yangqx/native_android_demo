package com.example.helloworld2.netease.okhttp;

import java.io.InputStream;

public interface CallBackListener {

    void onSuccess(InputStream inputStream);

    void onFailture();

}
