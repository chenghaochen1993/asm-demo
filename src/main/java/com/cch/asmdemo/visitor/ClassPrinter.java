package com.cch.asmdemo.visitor;

import com.cch.asmdemo.model.Enginer;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import java.io.InputStream;

/**
 * @author: chenghao.chen
 * @date: 2019/11/2 11:30
 * @description:
 */
public class ClassPrinter extends ClassVisitor {
    /**
     * 兼容4-7版本
     */
    public ClassPrinter() {
        super(Opcodes.ASM7);
    }

    /**
     * step1
     * @param version 版本
     * @param access 是否可以访问
     * @param name 全路径类名
     * @param signature 泛型 <T:Ljava/lang/Object;>Ljava/lang/Object; 可以为null
     * @param superName 父类全路径名称
     * @param interfaces 类接口的内部名称
     */
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        System.out.println("visit: version: "+version+" access: "+access+" name: "+name+" signature: "+signature+" superName: "+superName);
    }

    /**
     * step2
     * @param source java文件名包含后缀:Student.java
     * @param debug 调试信息 可以为null
     */
    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
        System.out.println("visitSource: source:"+source +" debug:"+debug);
    }

    @Override
    public ModuleVisitor visitModule(String name, int access, String version) {
        System.out.println("visitModule:");
        return super.visitModule(name, access, version);
    }

    @Override
    public void visitNestHost(String nestHost) {
        System.out.println("visitModule:");
        super.visitNestHost(nestHost);
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
        System.out.println("visitOuterClass:");
        super.visitOuterClass(owner, name, descriptor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.println("visitAnnotation:");
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.out.println("visitTypeAnnotation:");
        return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        System.out.println("visitAttribute:");
        super.visitAttribute(attribute);
    }

    @Override
    public void visitNestMember(String nestMember) {
        System.out.println("visitNestMember:");
        super.visitNestMember(nestMember);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        System.out.println("visitInnerClass:");
        super.visitInnerClass(name, outerName, innerName, access);
    }

    /**
     * step3
     * @param access 访问类型 public:1 private:2 proteced:4
     * @param name 属性名称
     * @param descriptor 字节码描述符
     * @param signature 泛型
     * @param value 值
     * @return
     */
    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println("visitField: access:"+access+" name:"+name+" descriptor:"+descriptor+" signature:"+signature+" value:"+value);
        return super.visitField(access, name, descriptor, signature, value);
    }

    /**
     * step4
     * @param access 访问类型
     * @param name 方法名称:getAge
     * @param descriptor 字节码描述符 ()Ljava/langInteger;
     * @param signature 签名
     * @param exceptions 异常类:java/lang/Exception
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("visitMethod: access:"+access+ " name:"+name+" descriptor:"+descriptor);
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    /**
     * 结束方法
     */
    @Override
    public void visitEnd() {
        System.out.println("visitEnd");
        super.visitEnd();
    }
}
