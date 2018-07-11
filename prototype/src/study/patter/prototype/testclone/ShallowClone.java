package study.patter.prototype.testclone;

import study.patter.prototype.original.Desciption;
import study.patter.prototype.original.Original;

/*
 * date 20180712
 * author suxin
 * desciption  浅克隆只克隆地址
 * */
public class ShallowClone {
    public static void main(String[] args) {
        Original original = new Original();
        original.setId(1);
        original.setName("Original");
        Desciption desciption = new Desciption();
        desciption.setDesciption("this is child class");
        original.setDesciption(desciption);

        Original target = null;
        try {
            target = (Original)original.clone();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(target.getName() == original.getName()){
            System.out.println("name:"+true);
        }else{
            System.out.println("name:"+false);
        }

        if(target.getDesciption() == original.getDesciption()){
            System.out.println("desciption:"+true);
        }else{
            System.out.println("desciption:"+false);
        }

        System.out.println("original desciption is:"+original.getDesciption()+":"+original.getDesciption().getDesciption());
        System.out.println("target desciption is:"+target.getDesciption()+":"+target.getDesciption().getDesciption());

        desciption.setDesciption("This is change");
        original.setDesciption(desciption);
        original.setId(2);

        System.out.println("original desciption is:"+original.getDesciption()+":"+original.getDesciption().getDesciption());
        System.out.println("target desciption is:"+target.getDesciption()+":"+target.getDesciption().getDesciption());

        System.out.println("original id is:"+original.getId());
        System.out.println("target id is:"+target.getId());
    }
}
