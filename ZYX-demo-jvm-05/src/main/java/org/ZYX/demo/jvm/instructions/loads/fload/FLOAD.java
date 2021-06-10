package org.ZYX.demo.jvm.instructions.loads.fload;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

//load float from local variable
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(this.idx);
        frame.operandStack().pushFloat(val);
    }

}
