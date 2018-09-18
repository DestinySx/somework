package study.multithread.util;

import java.util.*;
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

    public static void main(String[] args) {
        test();
    }

    public static void sublistTest(){
        LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        List<String> l2 =  ll.subList(1, 2);//[)
        l2.add("new");
        System.out.println(ll);
        System.out.println(l2);
    }

    public static void test(){
        List<Integer> list = new ArrayList<Integer>();

        for(int i=1; i<=2000;i++){
            list.add(i);
        }

        Map<String,Object> map = new HashMap<>();

        for(int i=0; i<=list.size()/200;i++){
            if(i == list.size()/200){
                map.put("ids"+i,list.subList(i*200,list.size()));
            }else{
                map.put("ids"+i,list.subList(i*200,(i+1)*200));
            }
        }

        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

    }
}