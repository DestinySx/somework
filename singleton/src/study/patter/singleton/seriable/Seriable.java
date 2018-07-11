package study.patter.singleton.seriable;

import java.io.Serializable;

/*
 * time 20180710
 * author suxin
 * description 序列化实例
 * */
public class Seriable implements Serializable{

    private Seriable(){
    }
    private static Seriable seriable = new Seriable();

    public  static Seriable getIntance() {
       // System.out.println(System.currentTimeMillis()+":"+seriable);
        return seriable;
    }

    // 方法重写，确保序列化后生城的对象与序列化之前的完全一致
    private Object readResolve(){
        return seriable;
    }
}
