package org.ZYX.demo.jvm.instructions.loads.dload;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class DLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(2);
        frame.operandStack().pushDouble(val);
    }

}

