package study.patter.singleton.lazy;

/*
 * time 20180710
 * author suxin
 * */
public class LazySecond {

    private  LazySecond(){};

    private static LazySecond lazySecond = null;

    public static LazySecond getIntance(){
        if(lazySecond == null){
            lazySecond = new LazySecond();
        }
        // System.out.println(System.currentTimeMillis()+":"+lazyFirst);
        return lazySecond;
    }
}
