package com.cch.asmdemo.core;

/**
 * @author: chenghao.chen
 * @date: 2019/11/10 10:07
 * @description:
 */
public interface AdviceListener {

    /**
     * 前置通知
     *
     * @param loader     类加载器
     * @param className  类名
     * @param methodName 方法名
     * @param methodDesc 方法描述
     * @param target     目标类实例
     *                   若目标为静态方法,则为null
     * @param args       参数列表
     * @throws Throwable 通知过程出错
     */
    void before(
            ClassLoader loader, String className, String methodName, String methodDesc,
            Object target, Object[] args) throws Throwable;

    /**
     * 返回通知
     *
     * @param loader       类加载器
     * @param className    类名
     * @param methodName   方法名
     * @param methodDesc   方法描述
     * @param target       目标类实例
     *                     若目标为静态方法,则为null
     * @param args         参数列表
     * @param returnObject 返回结果
     *                     若为无返回值方法(void),则为null
     * @throws Throwable 通知过程出错
     */
    void afterReturning(
            ClassLoader loader, String className, String methodName, String methodDesc,
            Object target, Object[] args,
            Object returnObject) throws Throwable;

    /**
     * 异常通知
     *
     * @param loader     类加载器
     * @param className  类名
     * @param methodName 方法名
     * @param methodDesc 方法描述
     * @param target     目标类实例
     *                   若目标为静态方法,则为null
     * @param args       参数列表
     * @param throwable  目标异常
     * @throws Throwable 通知过程出错
     */
    void afterThrowing(
            ClassLoader loader, String className, String methodName, String methodDesc,
            Object target, Object[] args,
            Throwable throwable) throws Throwable;

}