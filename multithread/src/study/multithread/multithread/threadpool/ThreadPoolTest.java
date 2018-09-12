package study.multithread.multithread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/12   Time: 14:36
 * Description:
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {

        Mythread1[] mythreads = new Mythread1[]{
                new Mythread1() {
                    @Override
                    public void doSomeThing() {
                        dosomething();
                    }
                }
        };
        System.out.println("--------线程池启动-------");
        fixeThreadPool(mythreads);
    }

    public static void dosomething(){
        List<MyThread2> mythreadList = new ArrayList<>();
        for(int i=0;i<10;i++){
            MyThread2 thread = new MyThread2(i);
            mythreadList.add(thread);
        }
        MyThread2[] mythreads = mythreadList.toArray(new MyThread2[0]);
        fixeThreadPool(mythreads);
    }

    public static void fixeThreadPool(BeginThread mythreads[]){
        ExecutorService threadpool = Executors.newFixedThreadPool(5);
        for(BeginThread mythread:mythreads){
            threadpool.execute(mythread);
        }
        threadpool.shutdown();
    }
}