package org.ZYX.demo.jvm.classfile.attributes.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.attributes.AttributeInfo;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * create by ZYX on 2021/5/28
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int sourceFileIdx;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIdx = reader.readUint16();
    }

    public String fileName(){
        return this.constantPool.getUTF8(this.sourceFileIdx);
    }

}
