package com.cch.asmdemo.core;

import org.objectweb.asm.commons.Method;


/**
 * @author: chenghao.chen
 * @date: 2019/11/10 10:16
 * @description:
 */
public interface AsmMethods {
    class MethodFinder {

        private MethodFinder() {

        }

        static Method getAsmMethod(final Class<?> clazz, final String methodName, final Class<?>... parameterTypes) {
            return Method.getMethod(getJavaMethodUnsafe(clazz, methodName, parameterTypes));
        }

        static java.lang.reflect.Method getJavaMethodUnsafe(final Class<?> clazz, final String methodName,
                                                            final Class<?>... parameterTypes) {
            try {
                return clazz.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    Method AdviceWeaver_methodOnBegin = MethodFinder.getAsmMethod(
            AdviceWeaver.class,
            "methodOnBegin",
            int.class,
            ClassLoader.class,
            String.class,
            String.class,
            String.class,
            Object.class,
            Object[].class);

    Method AdviceWeaver_methodOnReturning = MethodFinder.getAsmMethod(
            AdviceWeaver.class,
            "methodOnReturning",
            Object.class
    );

    Method AdviceWeaver_methodOnThrowing = MethodFinder.getAsmMethod(
            AdviceWeaver.class,
            "methodOnThrowing",
            Throwable.class
    );

    Method Class_forName = MethodFinder.getAsmMethod(Class.class, "forName", String.class);

    Method OBJECT_getClass = MethodFinder.getAsmMethod(Object.class, "getClass");

    Method Class_getClassLoader = MethodFinder.getAsmMethod(Class.class, "getClassLoader");

}
