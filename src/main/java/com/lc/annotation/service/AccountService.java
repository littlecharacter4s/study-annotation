package com.lc.annotation.service;

import com.lc.annotation.custom.Observer;
import com.lc.annotation.pojo.Result;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Observer("orderIncomeObserver")
    public Result handleOrderIncome(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理订单收入!");
        Result result = new Result("success");
        result.setData("asodfhasdlfhasdlkf");
        return result;
    }

    @Observer("bonusImportObserver")
    public Object handleBonusImport(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理奖金导入!");
        return null;
    }
}
