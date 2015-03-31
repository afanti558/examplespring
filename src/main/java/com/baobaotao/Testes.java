package com.baobaotao;

import com.baobaotao.dao.Beana;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by xiaofan on 2015/3/30.
 */

public class Testes {

    ApplicationContext applicationContext;
    Beana beana;
    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
         beana = (Beana) applicationContext.getBean("beana");
    }


    @Test
    public void test1() {
        Map map = beana.getMap();
        System.out.println(map.toString());
        for(Object obj:map.entrySet()) {
            Map.Entry entry = (Map.Entry)obj;
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}