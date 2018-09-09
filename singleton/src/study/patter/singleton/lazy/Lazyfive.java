package study.patter.singleton.lazy;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/8   Time: 15:35
 * Description:
 **/
public class Lazyfive {
     private static class InstanceHolder {
         public static Lazyfive instance = new Lazyfive();
     }
     public static Lazyfive getInstance() {
         return InstanceHolder.instance ; // 这里将导致InstanceHolder类被初始化
     }
}
