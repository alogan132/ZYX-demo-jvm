package org.ZYX.demo.jvm.instructions.constants.consts;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class FCONST_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushFloat(2);
    }

}
