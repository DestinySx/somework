package com.sutest.factory.Abstract;

public class TastAbstract {

    public static void main(String[] args){
        AbstractFactory abstractFaxtoryImpl = new AbstractFaxtoryImpl();
        System.out.println(abstractFaxtoryImpl.baoma());
        System.out.println(abstractFaxtoryImpl.falali());
    }
}
