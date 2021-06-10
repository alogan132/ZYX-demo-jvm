package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantInfo;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantPool;

import java.util.Map;

/**
 * create by ZYX on 2021/5/28
 */
public class ConstantMemberRefInfo implements ConstantInfo {

    protected ConstantPool constantPool;
    protected int classIdx;
    private int nameAndTypeIdx;

    ConstantMemberRefInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUint16();
        this.nameAndTypeIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return 0;
    }

    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> nameAndDescriptor() {
        return this.constantPool.getNameAndType(this.nameAndTypeIdx);
    }

}
