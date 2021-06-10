package org.ZYX.demo.jvm.instructions.references;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex16;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;
import org.ZYX.demo.jvm.rtda.heap.constantpool.ClassRef;
import org.ZYX.demo.jvm.rtda.heap.constantpool.RunTimeConstantPool;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Class;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

public class INSTANCE_OF extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        if (null == ref){
            stack.pushInt(0);
            return;
        }
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef classRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = classRef.resolvedClass();
        if (ref.isInstanceOf(clazz)){
            stack.pushInt(1);
        } else {
            stack.pushInt(0);
        }
    }

}
