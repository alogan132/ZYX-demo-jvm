package org.ZYX.demo.jvm;

import com.alibaba.fastjson.JSON;
import org.ZYX.demo.jvm.instructions.Factory;
import org.ZYX.demo.jvm.instructions.base.BytecodeReader;
import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.rtda.Frame;
import org.ZYX.demo.jvm.rtda.Thread;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Method;


//指令集解释器
class Interpret {

    Interpret(Method method) {
        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);
        loop(thread, method.code());
    }

    private void loop(Thread thread, byte[] byteCode) {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();

        while (true) {
            //循环
            int pc = frame.nextPC();
            thread.setPC(pc);
            //decode
            reader.reset(byteCode, pc);
            byte opcode = reader.readByte();
            Instruction inst = Factory.newInstruction(opcode);
            if (null == inst) {
                System.out.format("Unsupported opcode：0x%x\n", opcode);
                break;
            }
            inst.fetchOperands(reader);
            frame.setNextPC(reader.pc());
            System.out.format("寄存器(指令)：0x%x -> %s => 局部变量表：%s 操作数栈：%s\n", opcode, inst.getClass().getSimpleName(), JSON.toJSONString(frame.localVars().getSlots()), JSON.toJSONString(frame.operandStack().getSlots()));
            //exec
            inst.execute(frame);
        }

    }

}
