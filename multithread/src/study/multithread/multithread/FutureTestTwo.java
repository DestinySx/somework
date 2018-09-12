package study.multithread.multithread;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/12   Time: 11:25
 * Description: Callable 加 线程池
 **/
public class FutureTestTwo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newSingleThreadExecutor();
        FutureTask<String> future = new FutureTask<>(new MyThread());

        threadpool.execute(future);

        System.out.println(future.get());


    }

    static class MyThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello world";
        }
    }
}