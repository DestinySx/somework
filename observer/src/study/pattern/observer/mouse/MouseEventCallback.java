package study.pattern.observer.mouse;

import study.pattern.observer.core.Event;

/*
 * time 20180723
 * author suxin
 * */
public class MouseEventCallback {

    public void onClick(Event e){
        System.out.println("这是鼠标单击以后要执行的逻辑");
        System.out.println("=======触发鼠标单击事件========\n" + e);
    }
    public void onDoubleClick(Event e){
        System.out.println("=======触发鼠标双击事件========\n" + e);
    }

    public void onUp(Event e){
        System.out.println("=======触发鼠标弹起事件========\n" + e);
    }

    public void onDown(Event e){
        System.out.println("=======触发鼠标按下事件========\n" + e);
    }
}
