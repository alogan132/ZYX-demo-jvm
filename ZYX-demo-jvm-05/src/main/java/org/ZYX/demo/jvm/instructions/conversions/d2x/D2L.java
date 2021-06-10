package org.ZYX.demo.jvm.instructions.conversions.d2x;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

public class D2L extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double d = stack.popDouble();
        long l = (long) d;
        stack.pushLong(l);
    }
}
