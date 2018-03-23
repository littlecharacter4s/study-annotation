package com.lc.annotation.observer;

import com.lc.annotation.pojo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class OrderIncomeObserver implements AccountObserver {
    @Override
    public Object adjust(ProceedingJoinPoint joinPoint) {
        try {
            Object o = joinPoint.proceed();
            Result result = (Result) o;
            if (result.isSuccess()) {
                System.out.println("OrderIncomeObserver:订单收入调整!" + result.getData());
            }
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
