package com.lc.annotation.monitor;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AccountMonitor {
    Object adjust(ProceedingJoinPoint joinPoint);
}
