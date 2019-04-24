package com.example.helloworld2;

import android.app.Activity;
import android.view.View;

import com.example.helloworld2.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;

    public MyClickListener(Activity activity){
        mActivity = activity;
    }

    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(mActivity,"click..MyClickListener.");
    }
}
