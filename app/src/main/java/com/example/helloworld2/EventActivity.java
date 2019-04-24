package com.example.helloworld2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.helloworld2.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent,mBtnMy,mBtnHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent = findViewById(R.id.btn_event);
        mBtnMy = findViewById(R.id.btn_my);
        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });

        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Listener","-----onClick-----");
            }
        });
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","-----onTouch-----");
                        break;
                }
                return false;
            }
        });

        //1.通过内部类实
        mBtnEvent.setOnClickListener(new OnClick());
        //2.通过匿名内部类
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("匿名内部类","click");
                ToastUtil.showMsg(EventActivity.this,"click...匿名内部类");
            }
        });

//3.通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);

        //4.通过外部类实现
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"click...verride");
                break;
        }
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_event:
                    Log.d("内部类","click");
                    ToastUtil.showMsg(EventActivity.this,"click.内部类..");
                    break;
            }
        }
    }

//    public void show(View view){
//        switch (view.getId()){
//            case R.id.btn_event:
//                ToastUtil.showMsg(EventActivity.this,"click...");
//                break;
//        }
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("EventAction","--onTouchEvent--");
                break;
        }
        return false;
    }

}
