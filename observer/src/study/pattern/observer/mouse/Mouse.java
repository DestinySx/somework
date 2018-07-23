package study.pattern.observer.mouse;

import study.pattern.observer.core.EventLisenter;

/*
 * time 20180723
 * author suxin
 * */
public class Mouse extends EventLisenter{
    public void click(){
        System.out.println("鼠标单击");
        this.trigger(MouseEventType.ON_CLICK);
    }
    public void doubleClick(){
        System.out.println("鼠标双击");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }
    public void up(){
        System.out.println("鼠标弹起");
        this.trigger(MouseEventType.ON_UP);
    }
    public void down(){
        System.out.println("鼠标按下");
        this.trigger(MouseEventType.ON_DOWN);
    }
}
