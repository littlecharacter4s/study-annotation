package com.lc.annotation.factory;

import com.lc.annotation.custom.Verifier;
import com.lc.annotation.util.SpringUtil;
import com.lc.annotation.verifier.FieldVerifier;

import java.util.Map;
import java.util.TreeMap;

public class VerifierFactory {
    private VerifierFactory() {
    }

    private static class VerifierFactoryInner {
        private VerifierFactoryInner() {
        }

        private static Map<String, FieldVerifier> treeMap = new TreeMap<>();

        static {
            SpringUtil.getApplicationContext()
                    .getBeansWithAnnotation(Verifier.class)
                    .forEach((key, value) -> treeMap.put(key, (FieldVerifier) value));
        }
    }

    public static Map<String, FieldVerifier> getVerifiers() {
        return VerifierFactoryInner.treeMap;
    }
}