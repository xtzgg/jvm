package com.jl.jvm.gcminitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BTrace的用法还有许多，打印调用堆栈、参数、返回值只是最基本的应用，
 * 在它的网站 上有使用BTrace进行性能监视、定位连接泄漏和内存泄漏、解决多线程竞争问题等例子
 */
public class BTraceTest {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(
            String[] args) throws IOException, InterruptedException {
        BTraceTest test = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<10; i++){
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
            Thread.sleep(5000);
        }
    }
}