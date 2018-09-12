package study.multithread.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/12   Time: 11:10
 * Description: Callable接口实现多线程
 **/
public class FutureTestOne {

    public static void main(String[] args) throws Exception {
        Task task1 = new Task();// 新建异步任务
        Task task2 = new Task();// 新建异步任务
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(task1);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(task2);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        System.out.printf("####:"+futureTask1.get());
        System.out.println("---over----");
    }


    // 异步任务
    static class Task implements Callable<Integer> {
        // 返回异步任务的执行结果
        @Override
        public Integer call() throws Exception {
            int i = 0;
            for (; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "_" + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
    }
}