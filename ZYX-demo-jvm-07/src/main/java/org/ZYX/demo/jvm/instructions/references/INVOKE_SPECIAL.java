package org.ZYX.demo.jvm.instructions.references;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex16;
import org.ZYX.demo.jvm.rtda.Frame;

public class INVOKE_SPECIAL  extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().popRef();
    }

}