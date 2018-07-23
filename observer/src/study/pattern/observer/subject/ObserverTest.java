package study.pattern.observer.subject;

import study.pattern.observer.core.Event;

import java.lang.reflect.Method;

/*
 * time 20180723
 * author suxin
 * */
public class ObserverTest {
    public static void main(String[] args) {
        try {
             Observer observer = new Observer();
             Method advice = Observer.class.getMethod("advice",new Class<?>[]{Event.class});

            Subject subject = new Subject();
            subject.addLisenter(SubjectEventType.ON_ADD,observer,advice);
            subject.addLisenter(SubjectEventType.ON_RMOVE,observer,advice);

            subject.add();
            subject.remove();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
