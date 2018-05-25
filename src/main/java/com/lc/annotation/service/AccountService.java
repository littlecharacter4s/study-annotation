package com.lc.annotation.service;

import com.lc.annotation.custom.Monitor;
import com.lc.annotation.pojo.Result;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Monitor("orderIncomeMonitor")
    public Result handleOrderIncome(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理订单收入!");
        Result result = new Result("success");
        result.setData("asodfhasdlfhasdlkf");
        return result;
    }

    @Monitor("bonusImportMonitor")
    public Object handleBonusImport(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理奖金导入!");
        return null;
    }

    public void proxy() {
        System.out.println("测试代理！");
    }

    public void handle() {
        this.handleOrderIncome(111111111L, 27L);
    }
}
