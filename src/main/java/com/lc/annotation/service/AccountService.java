package com.lc.annotation.service;

import com.lc.annotation.custom.Observer;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Observer("orderIncomeObserver")
    public Object handleOrderIncome(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理订单收入!");
        return null;
    }

    @Observer("bonusImportObserver")
    public Object handleBonusImport(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理奖金导入!");
        return null;
    }
}
