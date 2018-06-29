package com.lc.annotation.verifier;

import com.lc.annotation.custom.NotNull;
import com.lc.annotation.custom.Verifier;
import com.lc.annotation.pojo.Result;
import com.lc.annotation.util.ResultUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Verifier(NotNull.ORDER)
public class NotNullVerifier extends AbstractVerifier {
    @Override
    public Result verify(Object obj, Field field) throws Exception {
        NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
        if (null != notNullAnnotation) {
            String methodName = this.getMethodName(field);
            Method method = obj.getClass().getMethod(methodName);
            Object result = method.invoke(obj);
            return result == null || "".equals(result) ? ResultUtil.fail(notNullAnnotation.describe()) : ResultUtil.success();
        }
        return ResultUtil.success();
    }
}
