package org.ZYX.demo.jvm.instructions.loads.aload;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

public class ALOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(0);
        frame.operandStack().pushRef(ref);
    }

}
