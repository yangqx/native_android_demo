package com.example.helloworld2.netease.okhttp;

import android.text.format.Time;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

//线程池管理类
public class ThreadPoolManager {

    private  static  ThreadPoolManager threadPoolManager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance(){
        return  threadPoolManager;
    }

    //创建队列
    private LinkedBlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();

    //将异步任务添加到队列中
    public  void addTask(Runnable runnable){
        if(runnable != null){
            try {
                mQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //创建线程池
    private ThreadPoolExecutor mThreadPoolExecutor;
    private ThreadPoolManager(){

//        mThreadPoolExecutor = new ThreadPoolExecutor(3, 10, 15, SECONDS);
        //new ThreadPoolExecutor
        mThreadPoolExecutor = new ThreadPoolExecutor(3, 10, 15, SECONDS,
                new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                addTask(runnable);
            }
        });
        mThreadPoolExecutor.execute(coreThread);
    }

    //创建“叫号员”线程，让队列和线程进行交互
    public Runnable coreThread = new Runnable() {
        Runnable runnable = null;
        @Override
        public void run() {
            while (true){
                try {
                    runnable = mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mThreadPoolExecutor.execute(runnable);
            }
        }
    };

}
