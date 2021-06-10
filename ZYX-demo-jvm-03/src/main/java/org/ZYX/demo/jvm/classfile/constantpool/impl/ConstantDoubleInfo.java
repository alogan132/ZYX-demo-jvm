package org.ZYX.demo.jvm.classfile.constantpool.impl;

import org.ZYX.demo.jvm.classfile.ClassReader;
import org.ZYX.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * create by ZYX on 2021/05/13
 */
public class ConstantDoubleInfo implements ConstantInfo {

    private double val;

    @Override
    public void readInfo(ClassReader reader) {
          this.val = reader.readUint64TDouble();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }

    public double value(){
        return this.val;
    }

}
