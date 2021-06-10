package org.ZYX.demo.jvm.instructions.math.sub;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

//subtract int
public class ISUB extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int res = v1 - v2;
        stack.pushInt(res);
    }

}
