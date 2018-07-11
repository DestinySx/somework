package study.patter.singleton.test;

import study.patter.singleton.lazy.LazyThird;

import java.lang.reflect.Constructor;

/*
 * time 20180710
 * author suxin
 * */
public class LazyThirdTest {
    public static void main(String[] args) {
        try{
            Class<?> clazz = LazyThird.class;
            //通过反射拿到私有方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();

            Object o2 = c.newInstance();

            System.out.println(o1 == o2);
        }catch(Exception e){
            e.printStackTrace();
    }
    }
}
