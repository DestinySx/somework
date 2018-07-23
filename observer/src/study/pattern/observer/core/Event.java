package study.pattern.observer.core;

import java.lang.reflect.Method;

/*
 * time 20180723
 * author suxin
 * */
public class Event {

    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;

    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tsource=" + source + ",\n" +
                "\ttarget=" + target + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + '\'' + "\n" +
                '}';
    }


}
