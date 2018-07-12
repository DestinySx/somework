package study.patter.singleton.register;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * time 20180710
 * author suxin
 * description 注册登记式
 * */
public class Register {
    private void Register(){}

    public static Map<String,Register> list  = new ConcurrentHashMap<>();

    public static Register getIntance(String name){
        if(name == null){
            name = Register.class.getName();
        }
        if(list.get(name) == null){
            synchronized (Register.class) {
                if (list.get(name) == null) {
                    list.put(name, new Register());
                }
            }
        }
        return list.get(name);
    }
}
