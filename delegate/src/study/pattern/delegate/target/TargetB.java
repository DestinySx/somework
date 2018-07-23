package study.pattern.delegate.target;

/*
 * time 20180717
 * author suxin
 * */
public class TargetB  implements Target {
    @Override
    public void doSomething() {
        System.out.println("This is login");
    }
}
