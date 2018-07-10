package com.sutest.factory.simple;

import com.sutest.factory.BaoMa;

public class Test {
    public static void main(String[] args){
//            System.out.print(new BaoMa().getCar());
        TestFactory testFactory = new TestFactory();
        System.out.print(testFactory.getCar("BaoMa"));
    }
}
