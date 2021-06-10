package org.ZYX.demo.jvm.rtda.heap.methodarea;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ZYX on 2021/5/28
 */
public class MethodDescriptor {

    public List<String> parameterTypes = new ArrayList<>();
    public String returnType;

    public void addParameterType(String type){
        this.parameterTypes.add(type);
    }

}
