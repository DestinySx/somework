package study.multithread.chaptereight;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/11   Time: 14:56
 * Description:  isBroken()方法用来了解阻塞的线程是否被中断
 **/
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);
    public static void main(String[] args) throws InterruptedException,BrokenBarrierException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }

        System.out.println(c.isBroken());
    }
}