package org.ZYX.demo.jvm.instructions.stores.fstore;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

public class FSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, this.idx);
    }

}
