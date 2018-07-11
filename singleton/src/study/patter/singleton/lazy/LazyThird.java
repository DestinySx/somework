package study.patter.singleton.lazy;

/*
 * time 20180710
 * author suxin
 * */
public class LazyThird {

    private static boolean initialized = false;

    //默认使用LazyThree的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private LazyThird(){
        synchronized (LazyThird.class){
            if(initialized == false){
                initialized = !initialized;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }

    }

    //final 保证方法不能被重写，重载
    //ststic 为了使单例空间共享
    public final static LazyThird getInstance(){
        return LazyHolder.lazyThird;
    }

    private static class LazyHolder{
        private static LazyThird lazyThird = new LazyThird();
    }

}
