package org.ZYX.demo.jvm.instructions.extended.ifnull;

import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.instructions.base.InstructionBranch;
import org.ZYX.demo.jvm.rtda.Frame;

public class IFNONNULL extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack().popRef();
        if (null != ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}