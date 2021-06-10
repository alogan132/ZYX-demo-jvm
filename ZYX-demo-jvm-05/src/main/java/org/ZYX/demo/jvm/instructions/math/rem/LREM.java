package org.ZYX.demo.jvm.instructions.math.rem;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

//remainder long
public class LREM extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v2 == 0){
            throw new ArithmeticException("/ by zero");
        }
        long res = v1 % v2;
        stack.pushLong(res);
    }

}
