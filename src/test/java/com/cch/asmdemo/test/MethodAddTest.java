package com.cch.asmdemo.test;

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
 * @date: 2019/11/2 16:05
 * @description:
 */
public class MethodAddTest{

    @Test
    public void test()throws Exception{
        ClassReader cr = new ClassReader("com.cch.asmdemo.model.Enginer");
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new ClassVisitor(Opcodes.ASM7,cw){};
        cr.accept(cv,0);
        //新增一个方法
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC,
                "add",
                "()V",
                null,
                null);
        //load System.out
        mv.visitFieldInsn(Opcodes.GETSTATIC,
                "java/lang/System",
                "out",
                "Ljava/io/PrintStream;");
        //the constant to be loaded on the stack
        mv.visitLdcInsn("this is add method print!");
        //invoke println
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        byte[] data = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream(new File("/Users/xmly/Desktop/class/EnginerAdd.class"));
        fos.write(data);
        fos.flush();
        fos.close();
    }




}
