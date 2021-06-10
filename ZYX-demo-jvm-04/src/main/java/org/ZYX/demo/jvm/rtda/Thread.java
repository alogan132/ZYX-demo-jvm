package org.ZYX.demo.jvm.rtda;

public class Thread {

    //Program Counter 寄存器
    private int pc;

    //虚拟机栈
    private JvmStack stack;

    public Thread(){
        this.stack = new JvmStack(1024);
    }

    public int pc(){
        return this.pc;
    }

    public void setPC(int pc){
        this.pc = pc;
    }

    public void pushFrame(Frame frame){
        this.stack.push(frame);
    }

    public Frame popFrame(){
        return this.stack.pop();
    }

    public Frame currentFrame(){
        return this.stack.top();
    }

}
