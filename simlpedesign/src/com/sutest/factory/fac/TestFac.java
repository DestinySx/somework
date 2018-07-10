package com.sutest.factory.fac;

public class TestFac {

    public static void main(String[] args){
        BaoMaFactory baoMaFactory = new BaoMaFactory();
        System.out.print(baoMaFactory.getCar());
    }
}
