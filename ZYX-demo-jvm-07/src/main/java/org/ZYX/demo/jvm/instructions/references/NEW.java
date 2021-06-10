package org.ZYX.demo.jvm.instructions.references;

import org.ZYX.demo.jvm.instructions.base.ClassInitLogic;
import org.ZYX.demo.jvm.instructions.base.InstructionIndex16;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.heap.constantpool.ClassRef;
import org.ZYX.demo.jvm.rtda.heap.constantpool.RunTimeConstantPool;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Class;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

public class NEW extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef classRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = classRef.resolvedClass();
        if (!clazz.initStarted()) {
            frame.revertNextPC();
            ClassInitLogic.initClass(frame.thread(), clazz);
            return;
        }

        if (clazz.isInterface() || clazz.isAbstract()) {
            throw new InstantiationError();
        }
        
        Object ref = clazz.newObject();
        frame.operandStack().pushRef(ref);
    }

}