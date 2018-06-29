package com.lc.annotation.util;

import com.lc.annotation.factory.VerifierFactory;
import com.lc.annotation.pojo.Result;
import com.lc.annotation.verifier.FieldVerifier;

import java.lang.reflect.Field;
import java.util.Map;

public class VerifyUtil {
    public static Result verify(Object obj) {
        if (obj == null) {
            return ResultUtil.fail(Result.ErrorCodeEnum.PARAMETER_NULL);
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, FieldVerifier> verifierMap = VerifierFactory.getVerifiers();
        for (Map.Entry<String, FieldVerifier> entry : verifierMap.entrySet()) {
            FieldVerifier verifier = entry.getValue();
            try {
                for (Field field : fields) {
                    Result result = verifier.verify(obj, field);
                    if (result != null && result.isFail()) {
                        return result;
                    }
                }
            } catch (Exception e) {
                System.out.println("verify:校验异常!" + e.getMessage());
                return ResultUtil.fail(Result.ErrorCodeEnum.SYSTEM_ERROR);
            }
        }
        return ResultUtil.success();
    }
}
