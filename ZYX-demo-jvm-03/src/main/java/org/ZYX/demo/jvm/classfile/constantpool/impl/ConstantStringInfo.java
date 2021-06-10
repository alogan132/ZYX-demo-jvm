package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantInfo;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * create by ZYX on 2021/05/13
 */
public class ConstantStringInfo implements ConstantInfo {

    private ConstantPool constantPool;
    private int strIdx;

    public ConstantStringInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.strIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_STRING;
    }

    public String string(){
        return this.constantPool.getUTF8(this.strIdx);
    }


}
