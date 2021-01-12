package com.jl.jvm.gcminitor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OOMObject {
    /**
     * 内存占位符对象，一个OOMObject大约占64KB
     */
    static class OOMObject1 {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(
            int num) throws InterruptedException {
        List<OOMObject1> list = new ArrayList<>();
        for (int i = 0; i < num; i++) { //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject1());
        }
//        System.gcfeature();
    }

    public static void main(String[] args) throws Exception {
        while(true){
            fillHeap(1000);
            System.gc();
        }

    }

}
