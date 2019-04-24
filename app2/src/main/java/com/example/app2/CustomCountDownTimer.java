package com.example.app2;

import android.os.Handler;

public class CustomCountDownTimer implements Runnable {
    private int time;
    private int countDownTime;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;
    //1.实时回调设置时间（观察者模式）；2.支持动态传入总时间 3.每过一秒，时间减一
    //4.总时间变到0时改变 成文字

    public CustomCountDownTimer(int time,ICountDownHandler countDownHandler){

        handler = new Handler();
        this.time = time;
        this.countDownTime = time;
        this.countDownHandler = countDownHandler;
    }

    //实现的具体逻辑
    @Override
    public void run() {
        if (isRun){
            if(countDownHandler != null){
                countDownHandler.onTicker(countDownTime);
            }

            if(countDownTime == 0){
                cancel();
                if(countDownHandler != null){
                    countDownHandler.onFinish();
                }
            }else{
                countDownTime = time--;
                handler.postDelayed(this,1000);
            }
        }
    }

    //开启倒计时
    public void start(){
        isRun = true;

        handler.post(this);
    }

    //跳出
    public void cancel(){
        isRun = false;

        handler.removeCallbacks(this);
    }

    //观察者回掉接口  （IOC 数据回调）
    public interface ICountDownHandler{

        //倒计时回调
        void onTicker(int time);

        //完成时回调
        void onFinish();
    }

}
