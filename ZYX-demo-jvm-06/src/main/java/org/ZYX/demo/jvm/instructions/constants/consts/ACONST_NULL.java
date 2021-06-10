package org.ZYX.demo.jvm.instructions.constants.consts;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

//push null
public class ACONST_NULL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushRef(null);
    }

}
