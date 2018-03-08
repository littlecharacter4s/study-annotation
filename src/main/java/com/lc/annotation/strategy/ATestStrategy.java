package com.lc.annotation.strategy;

import com.lc.annotation.custom.Strategy;

@Strategy("StrategyEnum.A")
public class ATestStrategy implements TestStrategy {
    @Override
    public void operate() {
        System.out.println("ATestStrategy:I am ATestStrategy!");
    }
}
