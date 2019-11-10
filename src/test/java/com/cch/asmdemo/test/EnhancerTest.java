package com.cch.asmdemo.test;

import com.cch.asmdemo.core.Enhancer;
import com.cch.asmdemo.minitor.WatchAdviceListener;
import com.cch.asmdemo.model.Enginer;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: chenghao.chen
 * @date: 2019/11/10 11:35
 * @description:
 */
public class EnhancerTest {
    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setTargetClass(Enginer.class);
        enhancer.setAdviceListener(new WatchAdviceListener());


        try {
            Object object = enhancer.enhance();
            Method method = object.getClass().getMethod("test",String.class);
            method.invoke(object,"cch");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
