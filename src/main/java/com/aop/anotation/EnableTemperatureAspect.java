package com.aop.anotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by xiaofan on 2015/4/20.
 * 引入温度接口增强
 */
@Component
@Aspect
public class EnableTemperatureAspect {

    @DeclareParents(value = "com.aop.anotation.ArithmeticCalculator", defaultImpl =Thermometer.class)
    public IThermometer thermometer;//要实现的目标接口
}
