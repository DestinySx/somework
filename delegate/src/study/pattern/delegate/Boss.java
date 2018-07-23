package study.pattern.delegate;

/*
 * time 20180717
 * author suxin
 * */
public class Boss {
    public static void main(String[] args) {

        //代理模式注重的是过程， 委派模式注重的是结果
        //策略模式注重是可扩展（外部扩展），委派模式注重内部的灵活和复用
        //委派的核心：就是分发、调度、派遣

        //委派模式：就是静态代理和策略模式一种特殊的组合


        new Manager().doSomething("register");
    }
}
