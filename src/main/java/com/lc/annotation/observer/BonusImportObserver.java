package com.lc.annotation.observer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class BonusImportObserver implements AccountObserver {
    @Override
    public Object adjust(ProceedingJoinPoint joinPoint) {
        try {
            Object o = joinPoint.proceed();
            System.out.println("BonusImportObserver:奖金导入调整!");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
