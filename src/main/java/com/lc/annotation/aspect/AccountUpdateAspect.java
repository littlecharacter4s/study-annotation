package com.lc.annotation.aspect;

import com.lc.annotation.custom.Observer;
import com.lc.annotation.observer.AccountObserver;
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
    @Pointcut(value = "@annotation(com.lc.annotation.custom.Observer)")
    private void pointcut() {}

    @Around(value = "pointcut() && @annotation(observer)")
    public Object around(ProceedingJoinPoint joinPoint, Observer observer) {
        String observerName = observer.value();
        AccountObserver accountObserver = (AccountObserver)ApplicationContextUtil.getApplicationContext().getBean(observerName);
        System.out.println("joinPoint=" + joinPoint.toString());
        return accountObserver.adjust(joinPoint);
    }
}
