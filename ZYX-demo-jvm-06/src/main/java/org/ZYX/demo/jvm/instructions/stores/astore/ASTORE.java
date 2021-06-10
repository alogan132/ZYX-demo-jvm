package org.ZYX.demo.jvm.instructions.stores.astore;

import org.ZYX.demo.jvm.instructions.base.InstructionIndex8;
import org.ZYX.demo.jvm.rtda.Frame;

//store reference into local variable
public class ASTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}
