package study.patter.singleton.lazy;

/*
 * time 20180710
 * author suxin
 * desciption 懒汉式 在需要用到实例的时候才进行实例化，延时加载
 * */
public class LazyFirst {

    private  LazyFirst(){};

    private static LazyFirst lazyFirst = null;

    public static LazyFirst getIntance(){
        if(lazyFirst == null){
            lazyFirst = new LazyFirst();
        }
       // System.out.println(System.currentTimeMillis()+":"+lazyFirst);
        return lazyFirst;
    }
}
