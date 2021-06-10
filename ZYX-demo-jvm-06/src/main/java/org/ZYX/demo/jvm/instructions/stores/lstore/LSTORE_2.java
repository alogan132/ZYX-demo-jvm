package org.ZYX.demo.jvm.instructions.stores.lstore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class LSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 2);
    }

}
