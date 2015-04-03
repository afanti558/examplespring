package com.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by xiaofan on 2015/4/3.
 */
@Service
public class AopService implements IAopService{


    @Override
    public int sayHello() {
        System.out.println("你好。");
        return 0;
    }
}
