package org.ZYX.demo.jvm;

import org.ZYX.demo.jvm.classpath.Classpath;

import java.util.Arrays;

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
        Classpath cp = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath：%s class：%s args：%s\n", cp, cmd.getMainClass(), cmd.getAppArgs());
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        try {
            byte[] classData = cp.readClass(className);

            System.out.println(Arrays.toString(classData));

            System.out.println("classData：");
//            for (byte b : classData) {
//                //16进制输出
//                System.out.print(String.format("%02x", b & 0xff) + " ");
//            }
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + cmd.getMainClass());
            e.printStackTrace();
        }
    }

}
