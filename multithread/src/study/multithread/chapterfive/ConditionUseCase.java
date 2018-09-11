package study.multithread.chapterfive;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/10   Time: 17:15
 * Description:当调用await()方法后，当前线程会释放锁并在此等待，而其他线程调用Condition对象的signal()方法，
 *             通知当前线程后，当前线程才从await()方法返回，并且在返回前已经获取了锁。
 **/
public class ConditionUseCase {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    @Test
    public void test(){
        new Thread(()->{
            try {
                conditionWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                conditionSignal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("conditionWait start");
            condition.await();
            System.out.println("conditionWait end");
        } finally {
            lock.unlock();
        }
    } public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("conditionSignal start");
            condition.signal();
            System.out.println("conditionSignal end");
        } finally {
            lock.unlock();
        }
    }
}