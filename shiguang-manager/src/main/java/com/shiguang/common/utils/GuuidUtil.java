package com.shiguang.common.utils;

import java.util.concurrent.CountDownLatch;

public class GuuidUtil {

    private static long machineId = 0;

    private static long datacenterId = 0;

    /**

     * 单例模式创建雪花算法对象

     * */

    private enum SnowFlakeSingleton{

        Singleton;

        private SnowFlake snowFlake;

        SnowFlakeSingleton(){

            snowFlake = new SnowFlake(datacenterId,machineId);

        }

        public SnowFlake getInstance(){

            return snowFlake;

        }

    }

    public static long getUUID(){

        return SnowFlakeSingleton.Singleton.getInstance().nextId();

    }

    public static void main(String[] args) {
        String ss = "\u0001DLM\u0002IDNIDEK/LM-600P\u0017 R-06.50-01.50010\u0017PR00.00I\u0017PR00.00U\u0017 L-05.75-01.50179\u0017PL00.00O\u0017PL00.00U\u0017\u00041372";
        String aa = SpringUtil.getStringData(ss," R",2,"PR");
        System.out.println(aa);
        String fh = aa.substring(0,1);
        System.out.println(fh);
        String right = aa.substring(2,6);
        System.out.println(right);
        String bb = aa.substring(6,7);
        System.out.println(bb);
        String cc = aa.substring(8,12);
        System.out.println(cc);
        String dd = aa.substring(12,15);
        if ("0".equals(dd.substring(0,1))){
            dd = aa.substring(13,15);
        }
        System.out.println(dd);
//        String ee = SpringUtil.getStringData(ss," L",2,"PL");
//        System.out.println(ee);
//        String fh = ee.substring(0,1);
//        System.out.println(fh);
//        String right = ee.substring(2,6);
//        System.out.println(right);
//        String bb = ee.substring(6,7);
//        System.out.println(bb);
//        String cc = ee.substring(8,12);
//        System.out.println(cc);
//        String dd = ee.substring(13,15);
//        System.out.println(dd);

//         CountDownLatch latch = new CountDownLatch(10000);
//
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < 10000; i++) {
//
//            new Runnable() {
//
//                @Override
//
//                public void run() {
//
//                    System.out.println(GuuidUtil.getUUID());
//
//                    latch.countDown();
//
//                }
//
//            }.run();
//
//        }
//
//        try {
//
//            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
//
//            latch.await();//阻塞当前线程，直到计数器的值为0
//
//            System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
//
//        } catch (InterruptedException e) {
//
//            e.printStackTrace();
//
//        }
//
//        System.out.print("雪花算法用时： ");
//
//        System.out.println(System.currentTimeMillis() - start);

    }
    

}
