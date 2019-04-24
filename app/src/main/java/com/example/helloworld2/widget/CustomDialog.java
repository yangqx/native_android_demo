package com.example.helloworld2.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.helloworld2.R;

public class CustomDialog extends Dialog implements View.OnClickListener{
    private TextView mTvTitle,mTvMessage,mTvCancel,mTvConfirm;

    private String title,message,cancel,confirm;

    private IOnCancleListener cancleListener;
    private IOnConfirmListener confirmListener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return  this;

    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return  this;
    }

    public CustomDialog setCancel(String cancel,IOnCancleListener listener) {
        this.cancel = cancel;
        this.cancleListener = listener;
        return  this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return  this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度

        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8);
        getWindow().setAttributes(p);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confim);
        if(!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            mTvMessage.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                if(cancleListener != null){
                    cancleListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confim:
                if(confirmListener != null){
                    confirmListener.onCancel(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancleListener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener{
        void onCancel(CustomDialog dialog);
    }
}
