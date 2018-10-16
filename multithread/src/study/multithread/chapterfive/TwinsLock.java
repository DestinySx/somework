package study.multithread.chapterfive;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/10/15   Time: 15:56
 * Description: 自定义锁，每次允许两个线程获得锁
 **/
public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {

        private int count;
        public Sync(int count){
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        @Override
        public int tryAcquireShared(int reduceCount){
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if(newCount < 0 ||  compareAndSetState(current,newCount)){
                    return newCount;
                }
            }

        }

        @Override
        public boolean tryReleaseShared(int returnCount){
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }


    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}