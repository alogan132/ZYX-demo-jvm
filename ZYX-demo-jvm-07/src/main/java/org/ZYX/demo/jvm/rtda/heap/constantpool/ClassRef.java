package org.ZYX.demo.jvm.rtda.heap.constantpool;

import org.ZYX.demo.jvm.classfile.constantpool.impl.ConstantClassInfo;

public class ClassRef extends SymRef {

    public static ClassRef newClassRef(RunTimeConstantPool runTimeConstantPool, ConstantClassInfo classInfo) {
        ClassRef ref = new ClassRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.className = classInfo.name();
        return ref;
    }

}
