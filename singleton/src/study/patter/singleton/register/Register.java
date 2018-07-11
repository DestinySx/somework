package study.patter.singleton.register;

import java.util.HashMap;
import java.util.Map;

/*
 * time 20180710
 * author suxin
 * description 注册登记式
 * */
public class Register {
    private void Register(){}

    public static Map<String,Register> list  = new HashMap<String,Register>();

    public static Register getIntance(String name){
        if(name == null){
            name = Register.class.getName();
        }
        if(list.get(name) == null){
////            try{
////                list.put(name,(Register)Class.forName(name).newInstance());
////            }catch(Exception e){
////
////            }
            list.put(name,new Register());
        }
        return list.get(name);
    }
}
