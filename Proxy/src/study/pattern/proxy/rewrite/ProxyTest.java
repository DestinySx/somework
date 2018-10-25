package study.pattern.proxy.rewrite;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/10/25   Time: 21:04
 * Description:
 **/
public class ProxyTest {
    public static void main(String[] args) {

        Proxy_1 proxy_1 = new Proxy_1();
        Proxy_interfances proxy = (Proxy_interfances) proxy_1.getInstance(new ProxyPoto());

        proxy.sayHello();

    }
}