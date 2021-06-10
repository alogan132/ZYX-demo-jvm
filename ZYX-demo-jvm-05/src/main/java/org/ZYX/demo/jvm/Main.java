package org.ZYX.demo.jvm;

import org.ZYX.demo.jvm.classfile.ClassFile;
import org.ZYX.demo.jvm.classfile.MemberInfo;
import org.ZYX.demo.jvm.classpath.Classpath;

/**
 * create by ZYX on 2021/05/13
 * -Xjre "C:\Program Files\Java\jdk1.8.0_281\jre" D:\JavaProject\Idea-project\ZYX-demo-jvm\ZYX-demo-jvm-05\src\test\java\org\ZYX\demo\test\HelloWorld
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            //注意案例测试都是基于1.8，另外jdk1.9以后使用模块化没有rt.jar
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath:%s class:%s args:%s\n", classpath, cmd.getMainClass(), cmd.getAppArgs());
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, classpath);
        MemberInfo mainMethod = getMainMethod(classFile);
        if (null == mainMethod) {
            System.out.println("Main method not found in class " + cmd.classpath);
            return;
        }
        new Interpret(mainMethod);
    }

    private static ClassFile loadClass(String className, Classpath cp) {
        try {
            byte[] classData = cp.readClass(className);
            return new ClassFile(classData);
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + className);
            e.printStackTrace();
        }
        return null;
    }

    //找到主函数入口方法
    private static MemberInfo getMainMethod(ClassFile cf) {
        if (null == cf) return null;
        MemberInfo[] methods = cf.methods();
        for (MemberInfo m : methods) {
            if ("main".equals(m.name()) && "([Ljava/lang/String;)V".equals(m.descriptor())) {
                return m;
            }
        }
        return null;
    }

}
