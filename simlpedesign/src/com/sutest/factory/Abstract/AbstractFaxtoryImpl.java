package com.sutest.factory.Abstract;

import com.sutest.factory.Car;
import com.sutest.factory.DaZhong;
import com.sutest.factory.FaLaLi;
import com.sutest.factory.fac.BaoMaFactory;

public class AbstractFaxtoryImpl implements AbstractFactory{
    @Override
    public Car baoma() {
        return new BaoMaFactory().getCar();
    }

    @Override
    public Car falali() {
        return new FaLaLi();
    }

    @Override
    public Car dazhong() {
        return new DaZhong();
    }
}
