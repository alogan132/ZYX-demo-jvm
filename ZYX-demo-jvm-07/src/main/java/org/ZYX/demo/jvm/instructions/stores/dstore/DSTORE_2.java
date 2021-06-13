package org.ZYX.demo.jvm.instructions.stores.dstore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class DSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dstore(frame, 2);
    }

}

