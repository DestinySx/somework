package study.pattern.observer.mouse;

import study.pattern.observer.core.Event;

import java.lang.reflect.Method;

/*
 * time 20180723
 * author suxin
 * */
public class MouseTest {
    public static void main(String[] args) {

        try {

            MouseEventCallback callback = new MouseEventCallback();
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);
            Method onDoubleClick = MouseEventCallback.class.getMethod("onDoubleClick", Event.class);

            Mouse mouse = new Mouse();
            mouse.addLisenter(MouseEventType.ON_CLICK, callback, onClick);
            mouse.addLisenter(MouseEventType.ON_CLICK, callback, onDoubleClick);


            mouse.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
