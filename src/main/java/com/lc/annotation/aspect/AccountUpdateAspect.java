package com.lc.annotation.aspect;

import com.lc.annotation.custom.Monitor;
import com.lc.annotation.monitor.AccountMonitor;
import com.lc.annotation.util.ApplicationContextUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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

    @AfterReturning(pointcut="execution(* com.lc.annotation.service.AccountService.proxy(..))", returning="returnValue")
    public void after(JoinPoint joinPoint, Object returnValue) {
        System.out.println("切面开始！");
        try {
            System.out.println("等待切面处理...");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("切面结束！");
    }
}
