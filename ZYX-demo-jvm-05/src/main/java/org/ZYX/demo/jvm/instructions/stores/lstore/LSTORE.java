package org.ZYX.demo.jvm.instructions.stores.lstore;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

public class LSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, this.idx);
    }

}
