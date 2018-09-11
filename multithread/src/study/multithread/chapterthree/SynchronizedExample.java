package study.multithread.chapterthree;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/7   Time: 15:55
 * Description:
 **/
public class SynchronizedExample {
    private int a = 0;
    private boolean flag = false;
    public synchronized void writer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = 1;
        flag = true;
    }
    public synchronized void reader() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag) {
            int i = a;
        }
    }

    public static void main(String[] args) {
        SynchronizedExample sync = new SynchronizedExample();
        new Thread(()->{
            sync.writer();
            System.out.println("threadA:"+sync.a+"------"+sync.flag);
            System.out.println(Thread.currentThread().getName());
        },"threadA").start();
        new Thread(()->{
            sync.reader();
            System.out.println("threadB:"+sync.a+"------"+sync.flag);
            System.out.println(Thread.currentThread().getName());
        },"threadB").start();
    }
}