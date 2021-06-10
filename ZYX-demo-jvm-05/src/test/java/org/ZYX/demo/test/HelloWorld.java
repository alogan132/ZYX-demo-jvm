package org.ZYX.demo.test;

/**
 * -Xjre "C:\Program Files\Java\jdk1.8.0_281\jre" D:\JavaProject\Idea-project\ZYX-demo-jvm\ZYX-demo-jvm-05\src\test\java\org\ZYX\demo\test\HelloWorld
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
    
}
