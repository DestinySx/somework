package study.pattern.proxy.custom;

import study.pattern.proxy.jdk.OnePerson;
import study.pattern.proxy.jdk.Person;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/4   Time: 13:04
 * Description:
 **/
public class CustonProocyTest {
    public static void main(String[] args) {
        try{
            Person person = (Person) new SFindLove().getInstance(new OnePerson());
            person.findJob();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}