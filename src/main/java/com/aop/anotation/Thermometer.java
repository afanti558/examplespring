package com.aop.anotation;

import org.springframework.stereotype.Component;

/**
 * Created by xiaofan on 2015/4/20.
 */
@Component
public class Thermometer implements IThermometer {
    @Override
    public String getTemperature() {
        return "今天气温很高30度。";
    }
}
