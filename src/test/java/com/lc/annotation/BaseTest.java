package com.lc.annotation;

import com.lc.annotation.enums.StrategyEnum;
import com.lc.annotation.factory.StrategyFactory;
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
        service.handleOrderIncome(111111111L, 27L);
        service.handleBonusImport(111111111L, 27L);
    }
}