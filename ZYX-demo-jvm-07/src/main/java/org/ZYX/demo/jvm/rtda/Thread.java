package org.ZYX.demo.jvm.rtda;

import org.ZYX.demo.jvm.rtda.heap.methodarea.Method;

/**
 * create by ZYX on 2021/5/28
 * 线程
 */
public class Thread {

    //Program Counter 寄存器
    private int pc;

    //虚拟机栈
    private JvmStack stack;

    public Thread() {
        this.stack = new JvmStack(1024);
    }

    public int pc() {
        return this.pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void pushFrame(Frame frame) {
        this.stack.push(frame);
    }

    public Frame popFrame() {
        return this.stack.pop();
    }

    public Frame currentFrame() {
        return this.stack.top();
    }

    public Frame topFrame(){
        return this.stack.top();
    }

    public boolean isStackEmpty(){
        return this.stack.isEmpty();
    }

    public Frame newFrame(Method method) {
        return new Frame(this, method);
    }

}
