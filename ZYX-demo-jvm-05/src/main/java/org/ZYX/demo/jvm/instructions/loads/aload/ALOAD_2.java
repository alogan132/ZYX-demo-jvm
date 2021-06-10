package org.ZYX.demo.jvm.instructions.loads.aload;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class ALOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(2);
        frame.operandStack().pushRef(ref);
    }

}

