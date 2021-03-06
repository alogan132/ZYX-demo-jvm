package org.ZYX.demo.jvm.instructions.references;

import org.ZYX.demo.jvm.instructions.base.BytecodeReader;
import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.instructions.base.MethodInvokeLogic;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.heap.constantpool.InterfaceMethodRef;
import org.ZYX.demo.jvm.rtda.heap.constantpool.RunTimeConstantPool;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Method;
import org.ZYX.demo.jvm.rtda.heap.methodarea.MethodLookup;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

/**
 * create by ZYX on 2021/5/28
 * invokeinterface调用接口方法
 */
public class INVOKE_INTERFACE implements Instruction {

    private int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
        reader.readByte();
        reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        InterfaceMethodRef methodRef = (InterfaceMethodRef) runTimeConstantPool.getConstants(this.idx);
        Method resolvedMethod = methodRef.resolvedInterfaceMethod();
        if (resolvedMethod.isStatic() || resolvedMethod.isPrivate()) {
            throw new IncompatibleClassChangeError();
        }
        Object ref = frame.operandStack().getRefFromTop(resolvedMethod.argSlotCount() - 1);
        if (null == ref) {
            throw new NullPointerException();
        }
        if (!ref.clazz().isImplements(methodRef.resolvedClass())) {
            throw new IncompatibleClassChangeError();
        }
        Method methodToBeInvoked = MethodLookup.lookupMethodInClass(ref.clazz(), methodRef.name(), methodRef.descriptor());
        if (null == methodToBeInvoked || methodToBeInvoked.isAbstract()) {
            throw new AbstractMethodError();
        }
        if (!methodToBeInvoked.isPublic()) {
            throw new IllegalAccessError();
        }

        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);

    }

}
