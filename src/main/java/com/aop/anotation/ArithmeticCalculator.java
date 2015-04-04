package com.aop.anotation;

import org.springframework.stereotype.Component;

/**
 * Created by xiaofan on 2015/4/4.
 */
@Component
public class ArithmeticCalculator implements IArithmeticCalculator {
    @Override
    public int add(int a, int b) {
        System.out.println("进行了加法计算：" + a + "+" + b);
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("进行了减法计算：" + a + "-" + b);
        return a - b;
    }
}
