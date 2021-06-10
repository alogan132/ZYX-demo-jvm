package org.ZYX.demo.jvm.rtda.heap;

import org.ZYX.demo.jvm.classfile.ClassFile;
import org.ZYX.demo.jvm.classpath.Classpath;
import org.ZYX.demo.jvm.rtda.heap.constantpool.RunTimeConstantPool;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Class;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Field;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Slots;

import java.util.HashMap;
import java.util.Map;

/*
class names:
    - primitive types: boolean, byte, int ...
    - primitive arrays: [Z, [B, [I ...
    - non-array classes: java/lang/Object ...
    - array classes: [Ljava/lang/Object; ...
*/
public class ClassLoader {

    private Classpath classpath;
    private Map<String, Class> classMap;

    public ClassLoader(Classpath classpath) {
        this.classpath = classpath;
        this.classMap = new HashMap<>();
    }

    public Class loadClass(String className) {
        Class clazz = classMap.get(className);
        if (null != clazz) return clazz;
        try {
            return loadNonArrayClass(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Class loadNonArrayClass(String className) throws Exception {
        byte[] data = this.classpath.readClass(className);
        if (null == data) {
            throw new ClassNotFoundException(className);
        }
        Class clazz = defineClass(data);
        link(clazz);
        return clazz;
    }

    private void link(Class clazz) {
        verify(clazz);
        prepare(clazz);
    }

    private void prepare(Class clazz) {
        calcInstanceFieldSlotIds(clazz);
        calcStaticFieldSlotIds(clazz);
        allocAndInitStaticVars(clazz);
    }

    private void allocAndInitStaticVars(Class clazz) {
        clazz.staticVars = new Slots(clazz.staticSlotCount);
        for (Field field : clazz.fields) {
            if (field.isStatic() && field.isFinal()) {
                initStaticFinalVar(clazz, field);
            }
        }
    }

    private void initStaticFinalVar(Class clazz, Field field) {
        Slots staticVars = clazz.staticVars;
        RunTimeConstantPool constantPool = clazz.runTimeConstantPool;
        int cpIdx = field.constValueIndex();
        int slotId = field.slotId();

        if (cpIdx > 0) {
            switch (field.descriptor()) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    Object val = constantPool.getConstants(cpIdx);
                    staticVars.setInt(slotId, (Integer) val);
                case "J":
                    staticVars.setLong(slotId, (Long) constantPool.getConstants(cpIdx));
                case "F":
                    staticVars.setFloat(slotId, (Float) constantPool.getConstants(cpIdx));
                case "D":
                    staticVars.setDouble(slotId, (Double) constantPool.getConstants(cpIdx));
                case "Ljava/lang/String;":
                    System.out.println("todo");
            }
        }

    }

    private void calcStaticFieldSlotIds(Class clazz) {
        int slotId = 0;
        for (Field field : clazz.fields) {
            if (field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.staticSlotCount = slotId;
    }

    private void calcInstanceFieldSlotIds(Class clazz) {
        int slotId = 0;
        if (clazz.superClass != null) {
            slotId = clazz.superClass.instanceSlotCount;
        }
        for (Field field : clazz.fields) {
            if (!field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.instanceSlotCount = slotId;
    }

    private void verify(Class clazz) {
        // 校验字节码，尚未实现
    }

    private Class defineClass(byte[] data) throws Exception {
        Class clazz = parseClass(data);
        clazz.loader = this;
        resolveSuperClass(clazz);
        resolveInterfaces(clazz);
        this.classMap.put(clazz.name, clazz);
        return clazz;
    }

    private void resolveInterfaces(Class clazz) throws Exception {
        int interfaceCount = clazz.interfaceNames.length;
        if (interfaceCount > 0) {
            clazz.interfaces = new Class[interfaceCount];
            for (int i = 0; i < interfaceCount; i++) {
                clazz.interfaces[i] = clazz.loader.loadClass(clazz.interfaceNames[i]);
            }
        }
    }

    private void resolveSuperClass(Class clazz) throws Exception {
        if (!clazz.name.equals("java/lang/Object")) {
            clazz.superClass = clazz.loader.loadClass(clazz.superClassName);
        }
    }

    private Class parseClass(byte[] data) {
        ClassFile classFile = new ClassFile(data);
        return new Class(classFile);
    }


}
