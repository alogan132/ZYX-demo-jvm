package org.ZYX.demo.jvm.instructions.stores.lstore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class LSTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 3);
    }

}

