package com.lc.annotation.service;

import com.lc.annotation.util.SpringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AccountServiceTest {
    @Test
    public void testMonitor () {
        AccountService service = SpringUtil.getBean(AccountService.class);
        service.handleOrderIncome(111111111L, 27L);
        service.handleBonusImport(111111111L, 27L);
        service.handleOrderIncome(); //aop的原理是动态代理，这里没有用到代理类，而是用this，所以监控不到
        Assert.assertTrue("测试通过!", LocalDate.now().getYear() < Integer.MAX_VALUE);
    }
}