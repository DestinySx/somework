package com.sutest.factory.fac;

import com.sutest.factory.Car;
import com.sutest.factory.FaLaLi;

public class FaLaLiFactory {
    public Car getCar(){
        return new FaLaLi();
    }
}
