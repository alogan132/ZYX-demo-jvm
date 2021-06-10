package org.ZYX.demo.jvm.instructions.control.rtn;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.Thread;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/27
 */
public class LRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        long val = currentFrame.operandStack().popLong();
        invokerFrame.operandStack().pushLong(val);
    }

}
