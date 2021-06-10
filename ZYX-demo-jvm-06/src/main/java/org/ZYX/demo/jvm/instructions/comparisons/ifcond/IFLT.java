package org.ZYX.demo.jvm.instructions.comparisons.ifcond;

import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.instructions.base.InstructionBranch;
import org.ZYX.demo.jvm.rtda.Frame;

public class IFLT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (val < 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}
