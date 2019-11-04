package com.cch.asmdemo.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author: chenghao.chen
 * @date: 2019/11/4 19:44
 * @description:
 */
public class MethodModifyVisitor extends MethodVisitor {
    public MethodModifyVisitor(MethodVisitor mv) {
        super(Opcodes.ASM7,mv);
    }

    /**
     * 在代码开始处新增代码
     */
    @Override
    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(Opcodes.INVOKESTATIC, "com/cch/agentdemo/core/ams/AopInterceptor", "beforeInvoke", "()V",false);
    }

    /**
     * 在代码 return前新增代码
     * @param opcode
     */
    @Override
    public void visitInsn(int opcode) {
        if(opcode == Opcodes.RETURN){
            this.visitMethodInsn(Opcodes.INVOKESTATIC, "com/cch/agentdemo/core/ams/AopInterceptor", "afterInvoke", "()V",false);
        }
        super.visitInsn(opcode);
    }
}
