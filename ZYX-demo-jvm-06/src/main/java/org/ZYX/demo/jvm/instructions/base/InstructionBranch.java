package org.ZYX.demo.jvm.instructions.base;

import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.OperandStack;

public class InstructionBranch implements Instruction {

    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }

    protected boolean _acmp(Frame frame){
        OperandStack stack = frame.operandStack();
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        return ref1.equals(ref2);
    }

}
