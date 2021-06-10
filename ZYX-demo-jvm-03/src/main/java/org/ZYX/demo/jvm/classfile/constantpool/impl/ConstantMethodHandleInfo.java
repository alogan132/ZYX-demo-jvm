package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * create by ZYX on 2021/05/13
 */
public class ConstantMethodHandleInfo implements ConstantInfo {

    private int referenceKind;
    private int referenceIndex;

    @Override
    public void readInfo(ClassReader reader) {
        this.referenceKind = reader.readUint8();
        this.referenceIndex = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODHANDLE;
    }
}
