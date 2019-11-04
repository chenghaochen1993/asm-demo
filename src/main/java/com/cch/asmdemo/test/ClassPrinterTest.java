package com.cch.asmdemo.test;

import com.cch.asmdemo.core.ClassPrinter;
import org.junit.Test;
import org.objectweb.asm.ClassReader;

/**
 * @author: chenghao.chen
 * @date: 2019/11/4 19:34
 * @description:
 */
public class ClassPrinterTest {
    @Test
    public void test()throws  Exception{
        ClassPrinter classPrinter=new ClassPrinter();
        ClassReader classReader=new ClassReader("com.cch.asmdemo.model.Enginer");
        classReader.accept(classPrinter,0);
    }

}
