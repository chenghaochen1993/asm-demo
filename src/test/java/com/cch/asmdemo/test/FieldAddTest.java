package com.cch.asmdemo.test;

import com.cch.asmdemo.visitor.FieldAddVisitor;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: chenghao.chen
 * @date: 2019/11/8 20:50
 * @description:
 */
public class FieldAddTest {
    @Test
    public void test()throws Exception{
        ClassReader cr = new ClassReader("com.cch.asmdemo.model.Enginer");
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new FieldAddVisitor(cw);
        cr.accept(cv,0);
        byte[] data = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream(new File("/Users/xmly/Desktop/class/EnginerFieldAdd.class"));
        fos.write(data);
        fos.flush();
        fos.close();
    }
}
