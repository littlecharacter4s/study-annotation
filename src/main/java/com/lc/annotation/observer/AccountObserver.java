package com.lc.annotation.observer;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AccountObserver {
    Object adjust(ProceedingJoinPoint joinPoint);
}
