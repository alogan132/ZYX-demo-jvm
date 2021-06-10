package org.ZYX.demo.jvm.instructions.stores.istore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class ISTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 2);
    }

}

