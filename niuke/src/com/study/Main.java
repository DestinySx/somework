package com.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/21   Time: 20:54
 * Description:
 **/
public class Main {

    // sort 排序
    private static  void sort(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(6);
        list.add(5);
        //Collections.sort(list);


        //
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i:list){
            System.out.print(i+" ");
        }
        return;
    }


    // 值传递
    private void change(int a,int b){
        a =10;
        b = 5;
    }

    private void change(String a,String b){
        a = "AQZ"; b="QWE";
    }

    private void change(List list){
        list.add("123");
    }

    private void change(Modle modle){
        modle.a = "QWWQ";
        modle.b = 312;
    }


    private void change(){
        Main main = new Main();
        int a=1,b=1;
        main.change(a,b);
        System.out.println("a==="+a);
        System.out.println("b==="+b);

        String c = "CCCC";
        String d=null;
        main.change(c,d);
        System.out.println("c==="+c);
        System.out.println("d==="+d);

        List<Object> list = new ArrayList<>();
        list.add("123");
        main.change(list);

        Modle modle = new Modle("123",123);
        main.change(modle);
        System.out.println("========");
    }

    public static void main(String[] args){
        sort();
    }

    private static class Modle{

        public Modle(String a, int b) {
            this.a = a;
            this.b = b;
        }

        String a;
        int b;
    }
}