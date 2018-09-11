package study.multithread.chapterfour.ConnectionPool;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/9   Time: 18:09
 * Description:  练习CountDownLatch用法
 **/
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {

    public static void main(String[] args) throws Exception {

        CountDownLatch runnerPrepareLatch = new CountDownLatch(1);
        CountDownLatch commanderPrepareLatch = new CountDownLatch(10);

        CountDownLatch runnerRunLatch = new CountDownLatch(1);
        CountDownLatch commanderRunlatch = new CountDownLatch(10);

        System.out.println("选手们进场");

        ExecutorService service = Executors.newCachedThreadPool();

        System.out.println("裁判员发出准备指令");
        //runnerPrepareLatch.countDown();

        for(int i = 0;i<10;i++) {
            final int j = i;

            service.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println("运动员"+j+"进行准备");
                    try {
                        //runnerPrepareLatch.await();
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        System.out.println("运动员"+j+"准备完成");
                        commanderPrepareLatch.countDown();
                    }

                    try {
                        runnerRunLatch.await();
                        long time = (long)(Math.random()*1000);
                        Thread.sleep(time);
                        System.out.println("经历"+time+"秒");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        //commanderRunlatch.countDown();
                        System.out.println("运动员"+j+"到达终点");
                    }
                }
            });
        }

        commanderPrepareLatch.await();
        System.out.println("都准备好，裁判员发出开始指令");
        runnerRunLatch.countDown();
        //commanderRunlatch.await();
        System.out.println("比赛结束");


        service.shutdown();
    }
}
