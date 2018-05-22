package com.lc.annotation.aspect;

import com.lc.annotation.custom.Monitor;
import com.lc.annotation.observer.AccountMonitor;
import com.lc.annotation.util.ApplicationContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountUpdateAspect {
    //切入点
    @Pointcut(value = "@annotation(com.lc.annotation.custom.Monitor)")
    private void pointcut() {}

    @Around(value = "pointcut() && @annotation(monitor)")
    public Object around(ProceedingJoinPoint joinPoint, Monitor monitor) {
        String observerName = monitor.value();
        AccountMonitor accountMonitor = (AccountMonitor)ApplicationContextUtil.getApplicationContext().getBean(observerName);
        System.out.println("joinPoint=" + joinPoint.toString());
        return accountMonitor.adjust(joinPoint);
    }
}
