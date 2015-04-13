package com.aop.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaofan on 2015/4/3.
 */
public class TestCase {
    @Test
    public void test(){
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
        //千万注意这里要去代理类，不是原来的实现类
        AopService aopService = (AopService) ctx.getBean("aopServiceProxy");
        aopService.sayHello();
    }
}
