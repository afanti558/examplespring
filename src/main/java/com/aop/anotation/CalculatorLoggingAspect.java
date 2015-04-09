package com.aop.anotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * Created by xiaofan on 2015/4/4.
 */
@Component
@Aspect
@Order(0)
public class CalculatorLoggingAspect {
//    private Log log = LogFactory.getLog(CalculatorLoggingAspect.class);

    @Before("execution(* IArithmeticCalculator.add(..))")
    public void logBefore( JoinPoint joinPoint){
        System.out.println("加法开始了,方法名称：" + joinPoint.getSignature().getName()
                + "，参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(String IArithmeticCalculator.*(..))")
    public void logAfter(){
        System.out.println("加法结束了");
    }
}
