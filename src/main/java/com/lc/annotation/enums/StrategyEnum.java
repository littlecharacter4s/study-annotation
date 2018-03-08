package com.lc.annotation.enums;

import java.util.Arrays;

public enum StrategyEnum {
    A(0, "AXX"),
    B(1, "BXX");

    private int code;
    private String desc;

    StrategyEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static StrategyEnum findStrategyEnum(Integer code) {
        return Arrays.stream(StrategyEnum.values()).filter(strategyEnum -> strategyEnum.getCode() == code).findFirst().orElse(null);
    }

    public static String getName (StrategyEnum strategyEnum) {
        return "StrategyEnum." + strategyEnum.name();
    }
}
