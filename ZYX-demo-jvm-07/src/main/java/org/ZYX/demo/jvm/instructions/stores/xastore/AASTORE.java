package org.ZYX.demo.jvm.instructions.stores.xastore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

/**
 * create by ZYX on 2021/5/28
 */
public class AASTORE extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        int idx = stack.popInt();
        Object arrRef = stack.popRef();

        if (null == arrRef) throw new NullPointerException();

    }
    
}
