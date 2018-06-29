package com.lc.annotation.aspect;

import com.lc.annotation.custom.Monitor;
import com.lc.annotation.monitor.AccountMonitor;
import com.lc.annotation.util.SpringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {
    //切入点
    @Pointcut(value = "@annotation(com.lc.annotation.custom.Monitor)")
    private void pointcut() {}

    @Around(value = "pointcut() && @annotation(monitor)")
    public Object around(ProceedingJoinPoint joinPoint, Monitor monitor) {
        String observerName = monitor.value();
        AccountMonitor accountMonitor = (AccountMonitor) SpringUtil.getBean(observerName);
        if (accountMonitor == null) {
            System.out.println("around:监视器为空!");
            return null;
        }
        return accountMonitor.adjust(joinPoint);
    }
}
