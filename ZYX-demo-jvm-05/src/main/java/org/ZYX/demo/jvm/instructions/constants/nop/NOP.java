package org.ZYX.demo.jvm.instructions.constants.nop;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class NOP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        //really do nothing
    }

}
