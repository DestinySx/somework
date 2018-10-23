package study.pattern.proxy.staticed.test;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/10/23   Time: 16:17
 * Description:
 **/
public class Base {
    static int num = 1;

    static {
        System.out.println("Base " + num);
    }
}