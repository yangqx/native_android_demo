package com.example.helloworld2;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld2.datastroage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnEvent,mBtnData,mBtnMD,mBtnOkHttp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        mBtnMD = findViewById(R.id.btn_material_design);
        mBtnOkHttp = findViewById(R.id.btn_ok_http);
        setListeners();

        //Android 6.0 以上需要动态请求权限
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnMD.setOnClickListener(onClick);
        mBtnOkHttp.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_material_design:
                    intent = new Intent(MainActivity.this, MaterialDesignActivity.class);
                    break;
                case R.id.btn_ok_http:
                    intent = new Intent(MainActivity.this, OkHttpActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
