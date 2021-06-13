package org.ZYX.demo.jvm.instructions.comparisons.dcmp;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class DCMPG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dcmp(frame, true);
    }
    
}
