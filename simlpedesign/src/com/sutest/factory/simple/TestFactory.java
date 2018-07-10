package com.sutest.factory.simple;

import com.sutest.factory.BaoMa;
import com.sutest.factory.Car;
import com.sutest.factory.DaZhong;
import com.sutest.factory.FaLaLi;

public class TestFactory {

    public Car getCar(String name){
        if("BaoMa".equals(name)){
            return new BaoMa();
        }else if("FaLaLi".equals(name)){
            return new FaLaLi();
        }else if("DaZhong".equals(name)){
            return new DaZhong();
        }else{
            return null;
        }

    }
}
