package study.multithread.util;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/9   Time: 13:54
 * Description:
 **/
public class SleepUtils {
    public static final void second(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}