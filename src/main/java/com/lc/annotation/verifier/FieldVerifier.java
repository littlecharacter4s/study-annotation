package com.lc.annotation.verifier;

import com.lc.annotation.pojo.Result;

import java.lang.reflect.Field;

public interface FieldVerifier {
    Result verify(Object obj, Field field) throws Exception;
}
