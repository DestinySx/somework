package study.patter.singleton.test;

import study.patter.singleton.register.Register;

import java.util.concurrent.CountDownLatch;

/*
 * time 20180710
 * author suxin
 * */
public class RegisterTest {
    public static void main(String[] agrs){

        long start = System.currentTimeMillis();
        int count = 200;
        CountDownLatch latch = new CountDownLatch(count);

        for(int i=0;i<count;i++){
            new Thread(){
                public void run(){
                    System.out.println(System.currentTimeMillis()+":"+ Register.getIntance(null));
                }
            }.start();
            latch.countDown();
        }

        try{
            latch.await();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        }catch(Exception e){

        }

//        for (int i = 0; i < 20000000;i ++) {
//            Object obj = Register.getIntance(null);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("总耗时：" + (end - start));
    }
}
