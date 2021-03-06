package org.ZYX.demo.jvm;

import org.ZYX.demo.jvm.classpath.Classpath;
import org.ZYX.demo.jvm.rtda.heap.ClassLoader;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Class;
import org.ZYX.demo.jvm.rtda.heap.methodarea.Method;

/**
 * create by ZYX on 2021/5/28
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag || args.length == 0) {
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
        ClassLoader classLoader = new ClassLoader(classpath);
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        Class mainClass = classLoader.loadClass(className);
        Method mainMethod = mainClass.getMainMethod();
        if (null == mainMethod) {
            throw new RuntimeException("Main method not found in class " + cmd.getMainClass());
        }
        new Interpret(mainMethod, cmd.verboseClassFlag);
    }

}
