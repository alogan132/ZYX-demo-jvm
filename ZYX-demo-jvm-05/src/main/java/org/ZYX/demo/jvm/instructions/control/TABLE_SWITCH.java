package org.ZYX.demo.jvm.instructions.control;

import org.ZYX.demo.jvm.instructions.base.BytecodeReader;
import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.rtda.Frame;

//access jump table by index and jump
public class TABLE_SWITCH implements Instruction {

    private int defaultOffset;
    private int low;
    private int high;
    private int[] jumpOffsets;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.readInt();
        this.low = reader.readInt();
        this.high = reader.readInt();
        int jumpOffsetCount = this.high - this.low + 1;
        this.jumpOffsets = reader.readInts(jumpOffsetCount);
    }

    @Override
    public void execute(Frame frame) {
        int idx = frame.operandStack().popInt();
        int offset;
        if (idx >= this.low && idx <= this.high) {
            offset = this.jumpOffsets[idx - this.low];
        } else {
            offset = this.defaultOffset;
        }
        Instruction.branch(frame, offset);
    }

}
