package com.example.helloworld2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld2.util.ToastUtil;
import com.example.helloworld2.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog = findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项").setCancel("取消", new CustomDialog.IOnCancleListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"cancel...");
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"confirm...");
                    }
                }).show();

            }
        });
    }
}
