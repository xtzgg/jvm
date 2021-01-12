package com.jl.jvm.gcfeature;

/**
 * 对象优先在eden区域分配
 *
 * 1.设置堆的最大和最小值
 * -Xmx20M(最大值) ,-Xms20M(最小值)。
 *
 * 2.设置年轻代的大小
 * -Xmn2g：设置年轻代大小为2G。整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小。持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。
 *
 * 3.设置栈的大小
 * -Xss128k： 设置每个线程的堆栈大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。更具应用的线程所需内存大小进行调整。在相同物理内 存下，减小这个值能生成更多的线程。但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。
 *
 * 4.设置出现内存溢出时,内存快照的保存路径
 * -XX:+HeapDumpOnOutOfMemoryError
 * 该配置会把快照保存在用户目录或者tomcat目录下，也可以通过 -XX:HeapDumpPath=/tmp/heapdump.hprof 来显示指定路径
 *
 * 5. -verbose:gcfeature
 * -verbose:gcfeature 中参数-verbose:gcfeature 表示输出虚拟机中GC的详细情况.
 *
 */
public class PriorityEden {

    private static final int _1MB = 1024 * 1024;

    /**
     * vm参数：-verbose:gcfeature -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次MinorGC
    }
}
