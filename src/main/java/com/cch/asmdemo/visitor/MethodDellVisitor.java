package com.cch.asmdemo.visitor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author: chenghao.chen
 * @date: 2019/11/4 19:40
 * @description:
 */
public class MethodDellVisitor extends ClassVisitor {
    public MethodDellVisitor(ClassWriter classWriter) {
        super(Opcodes.ASM7,classWriter);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if(name.startsWith("get")){
            return null;
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

}
