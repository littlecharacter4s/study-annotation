package com.lc.annotation.factory;

import com.lc.annotation.custom.Strategy;
import com.lc.annotation.strategy.TestStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class StrategyFactory {
    private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

    private StrategyFactory() {
    }

    private static class StrategyFactoryInner {
        private StrategyFactoryInner() {
        }

        private static Map<String, TestStrategy> strategyMap;

        static {
            applicationContext.getBeansWithAnnotation(Strategy.class).forEach((key, value) -> strategyMap.put(key, (TestStrategy) value));
        }
    }

    public static TestStrategy getStrategy(String strategy) {
        return StrategyFactoryInner.strategyMap.get(strategy);
    }
}