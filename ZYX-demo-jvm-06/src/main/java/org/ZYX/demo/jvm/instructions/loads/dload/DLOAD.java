package org.ZYX.demo.jvm.instructions.loads.dload;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

public class DLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(this.idx);
        frame.operandStack().pushDouble(val);
    }

}