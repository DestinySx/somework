package study.pattern.proxy.cglib;

import study.pattern.proxy.jdk.OnePerson;
import study.pattern.proxy.jdk.Person;

public class CglibTest {
    public static void main(String[] args) {

        try {
            Person obj = (Person)new CglibFindLove().getInstance(OnePerson.class);
            obj.findLove();
            System.out.println("--------------------------------");
            // System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
