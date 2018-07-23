package study.pattern.delegate.target;

/*
 * time 20180717
 * author suxin
 * */
public class TargetA implements Target {
    @Override
    public void doSomething() {
        System.out.println("This is register");
    }
}
