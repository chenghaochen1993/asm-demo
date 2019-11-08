package com.cch.asmdemo.test;

import com.cch.asmdemo.visitor.MethodDellVisitor;
import com.cch.asmdemo.visitor.MethodModifyVisitor;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: chenghao.chen
 * @date: 2019/11/4 19:45
 * @description:
 */
public class MethodModifyTest {
    @Test
    public void test()throws Exception{
        ClassReader cr = new ClassReader("com.cch.asmdemo.model.Enginer");
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new ClassVisitor(Opcodes.ASM7, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
                if (name.equals("accept")) {
                    return new MethodModifyVisitor(methodVisitor);
                }
                return methodVisitor;
            }
        };
        cr.accept(cv, 0);
        byte[] data = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream(new File("/Users/xmly/Desktop/class/EnginerModify.class"));
        fos.write(data);
        fos.flush();
        fos.close();
    }
}
