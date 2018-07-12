package study.pattern.proxy.staticed;

import java.lang.ref.SoftReference;
import java.net.SocketPermission;

public class SuperStart implements Start{

    public void planOfJob(){
        System.out.println("1,Making a movie");
        System.out.println("2.Participate in the activity");
    }

    @Override
    public void planOfMoney() {
        System.out.println("earn money");
    }

    @Override
    public void planOfFood() {
        System.out.println("eat vegetables");
    }
}
