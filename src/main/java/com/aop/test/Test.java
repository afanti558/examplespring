package com.aop.test;

import com.aop.service.IAopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaofan on 2015/4/3.
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
        IAopService aopService = (IAopService) ctx.getBean("aopService");
        aopService.sayHello();
    }
}
