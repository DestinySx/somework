package study.multithread.chaptereight;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/11   Time: 14:27
 * Description:CountDownLatch 应用
 **/
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                c.countDown();
                System.out.println(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                c.countDown();
                System.out.println(2);
            }
        }).start();
        c.await();
        System.out.println("3");
    }
}