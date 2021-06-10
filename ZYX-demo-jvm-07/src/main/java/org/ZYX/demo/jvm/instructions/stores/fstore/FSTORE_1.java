package org.ZYX.demo.jvm.instructions.stores.fstore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class FSTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, 1);
    }

}
