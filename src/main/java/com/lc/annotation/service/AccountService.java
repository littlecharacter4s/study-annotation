package com.lc.annotation.service;

import com.lc.annotation.pojo.Result;

public interface AccountService {
    void handleOrderIncome();
    Result handleOrderIncome(Long sid, Long businessId);
    Object handleBonusImport(Long sid, Long businessId);
}
