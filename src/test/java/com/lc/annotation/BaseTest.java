package com.lc.annotation;

import com.lc.annotation.enums.StrategyEnum;
import com.lc.annotation.factory.StrategyFactory;
import org.junit.Test;

public class BaseTest {
    @Test
    public void test () {
        StrategyFactory.getStrategy(StrategyEnum.getName(StrategyEnum.A)).operate();
        StrategyFactory.getStrategy(StrategyEnum.getName(StrategyEnum.B)).operate();
    }
}