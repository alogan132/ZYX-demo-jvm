package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * create by ZYX on 2021/5/28
 */
public class ConstantIntegerInfo implements ConstantInfo {

    private long val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint32();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }

    public long value(){
        return this.val;
    }

}
