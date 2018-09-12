package study.multithread.multithread.threadpool;

import study.multithread.util.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/12   Time: 15:34
 * Description:
 **/
public class MyThread2 extends BeginThread {

    private int i;

    protected MyThread2(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("----------------"+Thread.currentThread().getName()+"--------"+i);
        SleepUtils.second(1);
    }
}