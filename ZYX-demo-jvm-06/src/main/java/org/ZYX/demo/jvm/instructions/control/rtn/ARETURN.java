package org.ZYX.demo.jvm.instructions.control.rtn;

import org.ZYX.demo.jvm.instructions.base.InstructionNoOperands;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.Thread;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Object;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/27
 */
public class ARETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        Object ref = currentFrame.operandStack().popRef();
        invokerFrame.operandStack().pushRef(ref);
    }

}