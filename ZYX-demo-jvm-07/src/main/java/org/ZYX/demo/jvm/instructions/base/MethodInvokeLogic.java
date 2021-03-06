package org.ZYX.demo.jvm.instructions.base;

import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.Slot;
import org.ZYX.demo.jvm.rtda.Thread;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Method;

/**
 * create by ZYX on 2021/5/28
 */
public class MethodInvokeLogic {

    public static void invokeMethod(Frame invokerFrame, Method method) {
        Thread thread = invokerFrame.thread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);

        int argSlotCount = method.argSlotCount();
        if (argSlotCount > 0) {
            for (int i = argSlotCount - 1; i >= 0; i--) {
                Slot slot = invokerFrame.operandStack().popSlot();
                newFrame.localVars().setSlot(i, slot);
            }
        }

        //hack
        if (method.isNative()) {
            if ("registerNatives".equals(method.name())) {
                thread.popFrame();
            } else {
                throw new RuntimeException("native method " + method.name());
            }
        }
    }

}
