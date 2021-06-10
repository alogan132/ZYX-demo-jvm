package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * create by ZYX on 2021/5/28
 */
public class ConstantNameAndTypeInfo implements ConstantInfo {

     public int nameIdx;
     public int descIdx;

    @Override
    public void readInfo(ClassReader reader) {
         this.nameIdx = reader.readUint16();
         this.descIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_NAMEANDTYPE;
    }

}
