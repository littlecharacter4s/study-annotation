package com.lc.annotation.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

    private ApplicationContextUtil(){}

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");
        }
        return applicationContext;
    }
}
