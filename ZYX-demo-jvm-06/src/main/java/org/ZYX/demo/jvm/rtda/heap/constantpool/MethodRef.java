package org.ZYX.demo.jvm.rtda.heap.constantpool;

import org.ZYX.demo.jvm.classfile.constantpool.impl.ConstantMethodRefInfo;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Method;

public class MethodRef extends MemberRef {

    private Method method;

    public static MethodRef newMethodRef(RunTimeConstantPool runTimeConstantPool, ConstantMethodRefInfo refInfo){
        MethodRef ref = new MethodRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method ResolvedMethod(){
        if (null == this.method){
            this.resolveMethodRef();
        }
        return this.method;
    }

    private void resolveMethodRef() {

    }

}