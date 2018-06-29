package com.lc.annotation.verifier;

import com.lc.annotation.custom.NotNull;
import com.lc.annotation.custom.Verifier;
import com.lc.annotation.pojo.Result;
import com.lc.annotation.util.ResultUtil;

import java.lang.reflect.Field;

@Verifier(NotNull.ORDER)
public class NotNullVerifier extends AbstractVerifier {
    @Override
    public Result verify(Object obj, Field field) throws Exception {
        NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
        if (null != notNullAnnotation) {
            Object result = this.getInvokeValue(obj, field);
            return result == null || "".equals(result)
                    ? ResultUtil.fail(notNullAnnotation.describe())
                    : ResultUtil.success();
        }
        return ResultUtil.success();
    }
}
