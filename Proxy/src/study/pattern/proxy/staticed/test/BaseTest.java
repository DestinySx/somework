package study.pattern.proxy.staticed.test;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/10/23   Time: 16:16
 * Description:
 **/
public class BaseTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz1 = Base.class;
        System.out.println("------");
        Class clazz2 = Class.forName("study.pattern.proxy.staticed.test.Base");

    }
}