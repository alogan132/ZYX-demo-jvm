package org.ZYX.demo.jvm.instructions.stores.astore;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

public class ASTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 1);
    }

}
