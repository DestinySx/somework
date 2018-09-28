package study.multithread.chapterfour;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/9   Time: 14:51
 * Description: 安全和优雅的中断线程.使用isInterrupted() 或者 标志位判断
 **/
public class ShutdownThread {
    public static void main(String[] args) throws InterruptedException {

        Thread countThread = new Thread(new Runner(), "CountThread1");
        countThread.start();
        // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread2");
        countThread.start();
        // 睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(Thread.currentThread().getName()+"Count i = " + i);
        }
        public void cancel() {
            on = false;
        }
    }
}