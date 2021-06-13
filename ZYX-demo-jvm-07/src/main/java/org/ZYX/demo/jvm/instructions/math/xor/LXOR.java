package org.ZYX.demo.jvm.instructions.math.xor;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

//boolean xor long
public class LXOR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        long res = v1 ^ v2;
        stack.pushLong(res);
    }

}

