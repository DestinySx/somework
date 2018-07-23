package study.pattern.delegate;

import study.pattern.delegate.target.Target;
import study.pattern.delegate.target.TargetA;
import study.pattern.delegate.target.TargetB;

import java.util.HashMap;
import java.util.Map;

/*
 * time 20180717
 * author suxin
 * description 项目经理委派任务
 * */
public class Manager {

    private Map<String,Target> targers = new HashMap<String,Target>();

    public Manager(){
        targers.put("register",new TargetA());
        targers.put("login",new TargetB());
    }

    public void doSomething(String name){
        System.out.println("开始分配任务：");
        this.targers.get(name).doSomething();
        System.out.println("分配任务结束");
    }
}
