package com.lc.annotation;

import com.lc.annotation.enums.StrategyEnum;
import com.lc.annotation.factory.StrategyFactory;
import com.lc.annotation.pojo.Result;
import com.lc.annotation.service.AccountService;
import com.lc.annotation.util.ApplicationContextUtil;
import org.junit.Test;

public class BaseTest {
    @Test
    public void testStrategy () {
        StrategyFactory.getStrategy(StrategyEnum.getName(StrategyEnum.A)).operate();
        StrategyFactory.getStrategy(StrategyEnum.getName(StrategyEnum.B)).operate();
    }

    @Test
    public void testObserver () {
        AccountService service = ApplicationContextUtil.getApplicationContext().getBean(AccountService.class);
        Result result = service.handleOrderIncome(111111111L, 27L);
        if(result.isSuccess()){
            System.out.println("testObserver:处理成功!" + result.getData());
        } else {
            System.out.println("testObserver:处理失败!");
        }
        service.handleBonusImport(111111111L, 27L);
        service.handle(); //aop的原理是动态代理，这里没有用到代理类，而是用this，所以监控不到
    }

    @Test
    public void testProxy () {
        AccountService service = ApplicationContextUtil.getApplicationContext().getBean(AccountService.class);
        service.proxy();
        System.out.println("测试结束！");
    }
}