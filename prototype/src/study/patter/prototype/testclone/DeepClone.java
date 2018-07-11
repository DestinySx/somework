package study.patter.prototype.testclone;


import study.patter.prototype.original.Desciption;
import study.patter.prototype.original.Original;

/*
 * date 20180712
 * author suxin
 * desciptioni 深度克隆复制的不是一份引用，即新产生的对象和原始对象中的非基本数据类型的属性指向的不是同一个对象
 * */
public class DeepClone {
    public static void main(String[] args) {
        Original original = new Original();
        original.setId(1);
        original.setName("Original");
        Desciption desciption = new Desciption();
        desciption.setDesciption("this is child class");
        original.setDesciption(desciption);

        Original target = new Original();
        Desciption targetDesciption = new Desciption();
        targetDesciption.setDesciption(desciption.getDesciption());
        target.setId(original.getId());
        target.setDesciption(targetDesciption);
        target.setName(original.getName());


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
