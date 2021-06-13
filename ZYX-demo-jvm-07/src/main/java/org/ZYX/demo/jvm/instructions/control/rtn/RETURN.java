package org.ZYX.demo.jvm.instructions.control.rtn;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;

/**
 * create by ZYX on 2021/5/28
 */
public class RETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.thread().popFrame();
    }
    
}
