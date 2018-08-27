package study.patter.singleton.lazy;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/8/26   Time: 18:47
 * Description:
 **/
public class LazyFour{
    private LazyFour(){};

    private static volatile LazyFour lazyFour = null;

    public static LazyFour getInstance(){
        if(lazyFour == null){
            synchronized (LazyFour.class){
                if(lazyFour == null){
                    lazyFour = new LazyFour();
                }
            }
        }
        return lazyFour;
    }

    public static void main(String[] args) {

        for(int i = 0;i<100;i++){
            new Thread(()->{
                System.out.println(LazyFour.getInstance());
            }).start();
        }
    }
}