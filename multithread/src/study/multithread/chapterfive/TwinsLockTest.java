package study.multithread.chapterfive;

import org.junit.Test;
import study.multithread.util.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/10/15   Time: 16:11
 * Description: 自定义锁测试类
 **/
public class TwinsLockTest {
    @Test
    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            private int status;
            public Worker(int status){
                this.status = status;
            }
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName()+":  "+this.status);
                        SleepUtils.second(1);
                        return;
                    } finally {
                        lock.unlock();
                    }
                }
            }

        }
        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker(i);
            w.setDaemon(true);
            w.setName("qqqqqq"+i);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            //System.out.println("###################");
        }
    }
}