package org.ZYX.demo.jvm.instructions.control.rtn;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.Thread;

/**
 * create by ZYX on 2021/5/28
 */
public class IRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        int val = currentFrame.operandStack().popInt();
        invokerFrame.operandStack().pushInt(val);
    }

}
