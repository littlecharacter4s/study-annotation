package com.lc.annotation.observer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class OrderIncomeObserver implements AccountObserver {
    @Override
    public Object adjust(ProceedingJoinPoint joinPoint) {
        try {
            Object o = joinPoint.proceed();
            System.out.println("OrderIncomeObserver:订单收入调整!");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
