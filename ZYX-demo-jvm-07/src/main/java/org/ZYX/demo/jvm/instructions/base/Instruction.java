package org.ZYX.demo.jvm.instructions.base;

import org.ZYX.demo.jvm.rtda.Frame;

public interface Instruction {

    void fetchOperands(BytecodeReader reader);

    void execute(Frame frame);

    static void branch(Frame frame, int offset) {
        int pc = frame.thread().pc();
        int nextPC = pc + offset;
        frame.setNextPC(nextPC);
    }

}
