package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * create by ZYX on 2021/5/28
 */
public class ConstantFieldRefInfo extends ConstantMemberRefInfo {

    public ConstantFieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FIELDREF;
    }

}
