package org.ZYX.demo.jvm.instructions.stores.istore;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

public class ISTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _istore(frame, this.idx);
    }

}