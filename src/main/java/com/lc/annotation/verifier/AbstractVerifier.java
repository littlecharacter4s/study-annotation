package com.lc.annotation.verifier;

import java.lang.reflect.Field;

public abstract class AbstractVerifier implements FieldVerifier {
    String getMethodName(Field field) {
        char[] ch = field.getName().toCharArray();
        ch[0] -= 32;
        return "get" + new String(ch);
    }
}
