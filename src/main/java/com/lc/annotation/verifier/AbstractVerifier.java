package com.lc.annotation.verifier;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class AbstractVerifier implements FieldVerifier {
    private String getMethodName(Field field) {
        char[] ch = field.getName().toCharArray();
        ch[0] -= 32;
        return "get" + new String(ch);
    }

    Object getInvokeValue(Object obj, Field field) throws Exception {
        String methodName = this.getMethodName(field);
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }
}
