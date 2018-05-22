package com.lc.annotation.observer;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AccountMonitor {
    Object adjust(ProceedingJoinPoint joinPoint);
}
