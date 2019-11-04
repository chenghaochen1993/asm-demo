package com.cch.asmdemo.test;

import com.cch.asmdemo.visitor.MethodDellVisitor;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: chenghao.chen
 * @date: 2019/11/4 19:40
 * @description:
 */
public class MethodDelTest {

    @Test
    public void test()throws Exception{
        ClassWriter cw = new ClassWriter(0);
        MethodDellVisitor methodDellVisitor = new MethodDellVisitor(cw);
        ClassReader cr = new ClassReader("com.cch.asmdemo.model.Enginer");
        cr.accept(methodDellVisitor, 0);
        byte[] data = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream(new File("/Users/xmly/Desktop/class/EnginerDel.class"));
        fos.write(data);
        fos.flush();
        fos.close();
    }

}
