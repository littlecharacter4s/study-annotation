package com.lc.annotation.strategy;

import com.lc.annotation.custom.Strategy;

@Strategy("StrategyEnum.B")
public class BTestStrategy implements TestStrategy {
    @Override
    public void operate() {
        System.out.println("BTestStrategy:I am BTestStrategy!");
    }
}
