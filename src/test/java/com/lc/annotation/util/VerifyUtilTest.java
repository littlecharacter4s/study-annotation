package com.lc.annotation.util;

import com.alibaba.fastjson.JSON;
import com.lc.annotation.entity.User;
import com.lc.annotation.pojo.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class VerifyUtilTest {
    @Test
    public void testVerifyField() {
        User user = new User();
        Result result1 = VerifyUtil.verify(user);
        System.out.println("测试结果:" + JSON.toJSONString(result1));
        Assert.assertTrue("测试结果", result1.isFail());

        user.setId(1L);
        user.setUid(1L);
        user.setName("name");
        user.setBirthday(new Date());
        user.setMoney(1.0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setVersion(1);
        long start = System.currentTimeMillis();
        Result result2 = VerifyUtil.verify(user);
        long end = System.currentTimeMillis();
        System.out.println("测试结果:" + JSON.toJSONString(result2));
        System.out.println("耗时：" + (end - start));
        Assert.assertTrue("测试结果", result2.isSuccess());

        user.setUid(0L);
        Result result3 = VerifyUtil.verify(user);
        System.out.println("测试结果:" + JSON.toJSONString(result3));
        Assert.assertTrue("测试结果", result3.isFail());

        user.setUid(1L);
        user.setMoney(0.0);
        Result result4 = VerifyUtil.verify(user);
        System.out.println("测试结果:" + JSON.toJSONString(result4));
        Assert.assertTrue("测试结果", result4.isFail());

        user.setUid(1L);
        user.setMoney(1.0);
        user.setVersion(0);
        Result result5 = VerifyUtil.verify(user);
        System.out.println("测试结果:" + JSON.toJSONString(result5));
        Assert.assertTrue("测试结果", result5.isFail());
    }
}