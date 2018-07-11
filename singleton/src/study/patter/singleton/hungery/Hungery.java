package study.patter.singleton.hungery;

/*
 * time 20180710
 * author suxin
 * description 饿汉模式，不管实例是否使用，初始化时new一个实例，避免了线程安全问题
 * */
public class Hungery {

    private Hungery(){
    }

    private static Hungery hungery = new Hungery();

    public  static Hungery getIntance() {
        System.out.println(System.currentTimeMillis()+":"+hungery);
        return hungery;
    }
}
