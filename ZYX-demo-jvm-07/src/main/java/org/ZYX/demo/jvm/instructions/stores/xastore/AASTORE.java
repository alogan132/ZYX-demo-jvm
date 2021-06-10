package org.ZYX.demo.jvm.instructions.stores.xastore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/27
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
