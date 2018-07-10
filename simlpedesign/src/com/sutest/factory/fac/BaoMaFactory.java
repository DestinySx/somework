package com.sutest.factory.fac;

import com.sutest.factory.BaoMa;
import com.sutest.factory.Car;

public class BaoMaFactory{
    public Car getCar(){
        return new BaoMa();
    }
}
