package org.ZYX.demo.jvm.instructions.comparisons.if_acmp;

import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.instructions.base.InstructionBranch;
import org.ZYX.demo.jvm.rtda.Frame;

public class IF_ACMPNE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        if (!_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}