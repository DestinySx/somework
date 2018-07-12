package study.patter.singleton.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import study.patter.singleton.lazy.LazyFirst;
import study.patter.singleton.lazy.LazySecond;
import study.patter.singleton.lazy.LazyThird;


/*
* time 20180710
* author suxin
* */
public class Test extends Thread{

    public static void main(String[] agrs){
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);
        Set<LazyFirst> list = new HashSet<LazyFirst>();
        long start = System.currentTimeMillis();
        for(int i=0;i<count;i++){
            new Thread(){
                public void run(){
                    System.out.println(System.currentTimeMillis()+":"+ LazySecond.getIntance());
                    latch.countDown();
                }
            }.start();
        }

        try{
            latch.await();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        }catch(Exception e){

        }
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 200000000;i ++) {
//            Object obj = LazySecond.getIntance();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("总耗时：" + (end - start));
    }
}
