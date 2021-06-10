package org.ZYX.demo.jvm.instructions.math.neg;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

//negate float
public class FNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float val = stack.popFloat();
        stack.pushDouble(-val);
    }

}
