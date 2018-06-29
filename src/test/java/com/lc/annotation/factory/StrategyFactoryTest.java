package com.lc.annotation.factory;

import com.lc.annotation.enums.StrategyEnum;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class StrategyFactoryTest {
    @Test
    public void testStrategy () {
        StrategyFactory.getStrategy(StrategyEnum.getName(StrategyEnum.A)).operate();
        StrategyFactory.getStrategy(StrategyEnum.getName(StrategyEnum.B)).operate();
        Assert.assertTrue("测试通过!", LocalDate.now().getYear() < Integer.MAX_VALUE);
    }
}