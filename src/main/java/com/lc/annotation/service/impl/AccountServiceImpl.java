package com.lc.annotation.service.impl;

import com.lc.annotation.custom.Monitor;
import com.lc.annotation.pojo.Result;
import com.lc.annotation.service.AccountService;
import com.lc.annotation.util.ResultUtil;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void handleOrderIncome() {
        this.handleOrderIncome(111111111L, 27L);
    }

    @Override
    @Monitor("orderIncomeMonitor")
    public Result handleOrderIncome(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理订单收入!");
        return ResultUtil.success();
    }

    @Override
    @Monitor("bonusImportMonitor")
    public Object handleBonusImport(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理奖金导入!");
        return null;
    }
}
