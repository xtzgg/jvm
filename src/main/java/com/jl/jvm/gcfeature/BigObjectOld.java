package com.jl.jvm.gcfeature;

import java.io.IOException;

/**
 *
 * 大对象直接进入老年代
 *      默认Parallel Scavenge收集器对于PretenureSizeThreshold该参数设置失效，只有显式指定之后才会起作用
 */
public class BigObjectOld {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IOException {
        testPretenureSizeThreshold();
    }

    /**
     * VM参数：-verbose:gcfeature -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 //3MB
     *
     * 需要额外添加参数：-XX:+UseParallelGC
     */
    public static void testPretenureSizeThreshold() throws IOException {
        byte[] allocation;
        allocation = new byte[4 * _1MB];// 直接分配在老年代中
    }
}