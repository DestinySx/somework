package study.multithread.chaptereight;

import study.multithread.util.SleepUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/11   Time: 15:15
 * Description:控制并发线程数的Semaphore
 **/
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i< THREAD_COUNT; i++) {
            threadPool.execute(new Thread() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data"+Thread.currentThread().getName());
                        SleepUtils.second(1);
                        s.release();
                    } catch (InterruptedException e) {
                    }
                    //System.out.println("save data"+Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();
    }
}