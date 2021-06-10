package org.ZYX.demo.jvm.instructions.stores.istore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class ISTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 0);
    }

}
