package org.ZYX.demo.jvm.instructions.control.rtn;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.Thread;

/**
 * create by ZYX on 2021/5/28
 */
public class DRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        double val = currentFrame.operandStack().popDouble();
        invokerFrame.operandStack().pushDouble(val);
    }

}

