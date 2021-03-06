package study.multithread.chapterfour;

import study.multithread.util.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/9   Time: 14:32
 * Description: 线程中断  interrupt()
 **/
public class Interrupted {
    public static void main(String[] args) throws Exception {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("SleepThread interrupted is AAA" + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is AAA" + busyThread.isInterrupted());

        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(1);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                //System.out.println(Thread.currentThread().isInterrupted());
                //System.out.print("111");
            }
        }
    }
}