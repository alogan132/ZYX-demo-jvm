package org.ZYX.demo.jvm.classfile.attributes.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.attributes.AttributeInfo;

/**
 * create by ZYX on 2021/05/13
 */
public class ExceptionsAttribute implements AttributeInfo {

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        this.exceptionIndexTable = reader.readUint16s();
    }

    public int[] exceptionIndexTable(){
        return this.exceptionIndexTable;
    }

}
