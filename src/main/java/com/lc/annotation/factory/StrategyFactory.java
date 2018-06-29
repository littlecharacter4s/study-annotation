package com.lc.annotation.factory;

import com.lc.annotation.custom.Strategy;
import com.lc.annotation.strategy.TestStrategy;
import com.lc.annotation.util.SpringUtil;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
    private StrategyFactory() {
    }

    private static class StrategyFactoryInner {
        private StrategyFactoryInner() {
        }

        private static Map<String, TestStrategy> strategyMap = new HashMap<>();

        static {
            SpringUtil.getApplicationContext()
                    .getBeansWithAnnotation(Strategy.class)
                    .forEach((key, value) -> strategyMap.put(key, (TestStrategy) value));
        }
    }

    public static TestStrategy getStrategy(String strategy) {
        return StrategyFactoryInner.strategyMap.get(strategy);
    }
}