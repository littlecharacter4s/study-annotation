package com.lc.annotation.custom;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Observer {
    String value();
}
