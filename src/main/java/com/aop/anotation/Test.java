package com.aop.anotation;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaofan on 2015/4/4.
 */
public class Test {
    private ApplicationContext ctx;
    @Before
    public void Before(){
        ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @org.junit.Test
    public void Test1(){
        IArithmeticCalculator arithmeticCalculator = (IArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        System.out.println(arithmeticCalculator.add(2, 3));
        System.out.println("============================");
        System.out.println(arithmeticCalculator.sub(2, 3));
    }

}
