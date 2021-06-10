package org.ZYX.demo.jvm.rtda;

public class Frame {

    //stack is implemented as linked list
    Frame lower;

    //局部变量表
    private LocalVars localVars;

    //操作数栈
    private OperandStack operandStack;

    public Frame(int maxLocals, int maxStack) {
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars localVars(){
        return localVars;
    }

    public OperandStack operandStack(){
        return operandStack;
    }

}
