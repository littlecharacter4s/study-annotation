package com.lc.annotation.verifier;

import com.lc.annotation.custom.NotZero;
import com.lc.annotation.custom.Verifier;
import com.lc.annotation.pojo.Result;
import com.lc.annotation.util.ResultUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

@Verifier(NotZero.ORDER)
public class NotZeroVerifier extends AbstractVerifier {
    @Override
    public Result verify(Object obj, Field field) throws Exception {
        NotZero notZeroAnnotation = field.getAnnotation(NotZero.class);
        if (null != notZeroAnnotation) {
            String methodName = this.getMethodName(field);
            Method method = obj.getClass().getMethod(methodName);
            return BigDecimal.ZERO.compareTo(new BigDecimal(method.invoke(obj).toString())) == 0 ? ResultUtil.fail(notZeroAnnotation.describe()) : ResultUtil.success();
        }
        return ResultUtil.success();
    }
}
