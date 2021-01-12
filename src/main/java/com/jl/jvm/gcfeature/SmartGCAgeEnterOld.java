package com.jl.jvm.gcfeature;

/**
 * 动态年龄判断: 
 *  虚拟机并不是永远地要求对象的年龄必须达到 了MaxTenuringThreshold才能晋升老年代;
 *  如果在Survivor空间中相同年龄所有对象大小的总 和大于Survivor空间的一半;
 *  年龄大于或等于该年龄的对象就可以直接进入老年代;无须等 到MaxTenuringThreshold中要求的年龄。
 */
public class SmartGCAgeEnterOld {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testTenuringThreshold2();
    }

    /**
     * VM参数:-verbose:gcfeature -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4]; //allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
