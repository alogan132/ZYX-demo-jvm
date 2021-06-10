package org.ZYX.demo.jvm.instructions.loads.aload;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

//load reference from local variable
public class ALOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(this.idx);
        frame.operandStack().pushRef(ref);
    }

}
