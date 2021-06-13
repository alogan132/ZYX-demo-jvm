package org.ZYX.demo.jvm.instructions.constants.ipush;

import org.ZYX.demo.jvm.instructions.base.BytecodeReader;
import org.ZYX.demo.jvm.instructions.base.Instruction;
import org.ZYX.demo.jvm.rtda.Frame;

//bipush指令从操作数中获取一个byte型整数，扩展成int型，然后推入栈顶。
public class BIPUSH implements Instruction {

    private byte val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(val);
    }

}
