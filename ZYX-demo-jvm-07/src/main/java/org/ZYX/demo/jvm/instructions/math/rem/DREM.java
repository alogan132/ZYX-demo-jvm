package org.ZYX.demo.jvm.instructions.math.rem;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

//remainder double
public class DREM extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        double res = v1 % v2;
        stack.pushDouble(res);
    }

}
