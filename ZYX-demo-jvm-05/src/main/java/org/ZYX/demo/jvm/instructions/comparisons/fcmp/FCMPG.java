package org.ZYX.demo.jvm.instructions.comparisons.fcmp;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class FCMPG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, true);
    }

}
