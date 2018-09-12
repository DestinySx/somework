package study.multithread.multithread.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/12   Time: 14:43
 * Description:
 **/
public abstract class Mythread1 extends BeginThread{

    private long startIntervel;
    private long exeIntervel;
    private TimeUnit timeUnit;
    private int exeTimes;
    private boolean isDelay;


    protected Mythread1(){

    }

    protected Mythread1(long startIntervel, long exeIntervel, TimeUnit timeUnit, int exeTimes, boolean isDelay) {
        this.startIntervel = startIntervel;
        this.exeIntervel = exeIntervel;
        this.timeUnit = timeUnit;
        this.exeTimes = exeTimes;
        this.isDelay = isDelay;
    }

    @Override
    public void run() {
        doSomeThing();
    }

    public abstract void doSomeThing();

}