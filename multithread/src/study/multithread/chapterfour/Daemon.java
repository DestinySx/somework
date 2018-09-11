package study.multithread.chapterfour;

import study.multithread.util.SleepUtils;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/9   Time: 13:51
 * Description:在Java虚拟机退出时Daemon线程中的finally块并不一定会执行
 **/
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        //设置为守护进程
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}