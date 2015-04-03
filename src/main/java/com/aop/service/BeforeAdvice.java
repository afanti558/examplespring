package com.aop.service;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * Created by xiaofan on 2015/4/3.
 */
class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("这位顾客：");
    }

}
