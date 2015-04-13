package com.aop.service;

/**
 * Created by xiaofan on 2015/4/3.
 */

public class AopServiceImpl implements AopService {


    @Override
    public int sayHello() {
        System.out.println("你好。");
        return 0;
    }
}
