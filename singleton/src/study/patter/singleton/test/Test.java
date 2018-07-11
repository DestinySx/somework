package study.patter.singleton.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import study.patter.singleton.lazy.LazyFirst;


/*
* time 20180710
* author suxin
* */
public class Test extends Thread{

    public static void main(String[] agrs){
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);

        Set<LazyFirst> list = new HashSet<LazyFirst>();

        for(int i=0;i<count;i++){
            new Thread(){
                public void run(){
                    System.out.println(System.currentTimeMillis()+":"+LazyFirst.getIntance());
                }
            }.start();
            latch.countDown();
        }

        try{
            latch.await();
//            for (LazyFirst lazyFirst: list) {
//                System.out.println(lazyFirst);
//            }
        }catch(Exception e){

        }
    }
}
