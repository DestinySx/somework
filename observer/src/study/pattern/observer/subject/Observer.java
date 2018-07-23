package study.pattern.observer.subject;

import study.pattern.observer.core.Event;

/*
 * time 20180723
 * author suxin
 * */
public class Observer {
    public void advice(Event e){
        System.out.println("=========触发事件，打印日志========\n" + e);
    }

}
