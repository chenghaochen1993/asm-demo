package com.cch.asmdemo.visitor;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author: chenghao.chen
 * @date: 2019/11/6 19:33
 * @description:
 */
public class FieldAddVisitor extends ClassVisitor {
    public FieldAddVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7,classVisitor);
    }

    @Override
    public void visitEnd() {
       this.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC+Opcodes.ACC_FINAL,"NAME","Ljava/lang/String;",null,"JACK");
        super.visitEnd();
    }
}
