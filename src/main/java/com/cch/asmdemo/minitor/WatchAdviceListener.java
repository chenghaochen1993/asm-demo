package com.cch.asmdemo.minitor;

import com.cch.asmdemo.core.AdviceListener;

/**
 * @author: chenghao.chen
 * @date: 2019/11/10 10:10
 * @description:
 */
public class WatchAdviceListener implements AdviceListener {

    public void before(ClassLoader loader, String className, String methodName, String methodDesc, Object target, Object[] args) throws Throwable {
        System.out.println("advice before");
        if(args!=null && args.length>0){
            for(Object arg:args){
                System.out.println(arg);
            }
        }
    }

    public void afterReturning(ClassLoader loader, String className, String methodName, String methodDesc, Object target, Object[] args, Object returnObject) throws Throwable {
        System.out.println("advice afterReturning");
    }

    public void afterThrowing(ClassLoader loader, String className, String methodName, String methodDesc, Object target, Object[] args, Throwable throwable) throws Throwable {
        System.out.println("advice afterThrowing");
    }
}
