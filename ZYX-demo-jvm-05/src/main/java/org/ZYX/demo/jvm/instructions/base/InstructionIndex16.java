package org.ZYX.demo.jvm.instructions.base;

import org.ZYX.demo.jvm.rtda.Frame;

public class InstructionIndex16 implements Instruction {

    protected int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }
    
}
