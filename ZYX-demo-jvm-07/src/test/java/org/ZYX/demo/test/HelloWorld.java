package org.ZYX.demo.test;

/**

 * lload_0
 * lconst_1
 * lcmp
 * ifgt 7
 * lload_0
 * lreturn
 * lload_0
 * lconst_1
 * lsub
 * invokestatic org/itstack/demo/test/HelloWorld/fibonacci(J)J
 * lload_0
 * ldc2_w 2
 * lsub
 * invokestatic org/itstack/demo/test/HelloWorld/fibonacci(J)J
 * ladd
 * lreturn
 */
public class HelloWorld {

    public static void main(String[] args) {
        long x = fibonacci(10);
        System.out.println(x);
    }


    private static long fibonacci(long n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
