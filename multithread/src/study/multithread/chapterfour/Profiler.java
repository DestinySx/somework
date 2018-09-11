package study.multithread.chapterfour;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/9   Time: 17:20
 * Description: 获取线程的执行时间
 **/
public class Profiler {
    private final static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    private static void begin(){
        threadLocal.set(System.currentTimeMillis());
    }

    private static long end(){
        return System.currentTimeMillis() - threadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Profiler.end());    }
}