package study.patter.singleton.test;

import study.patter.singleton.register.Register;

/*
 * time 20180710
 * author suxin
 * */
public class RegisterTest {
    public static void main(String[] agrs){
        for(int i=0;i<100;i++){
            new Thread(){
                public void run(){
                    System.out.println(System.currentTimeMillis()+":"+ Register.getIntance(null));
                }
            }.start();
        }
    }

}
