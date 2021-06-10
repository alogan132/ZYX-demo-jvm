package org.ZYX.demo.jvm.instructions.math.neg;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

//negate int
public class INEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val = stack.popInt();
        stack.pushDouble(-val);
    }

}

