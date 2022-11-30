package com.tulun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author QiangQin
 * * @date 2022/11/19
 *
 *
 *
 *
 */

/*
https://blog.csdn.net/WX10301075WX/article/details/118162731
countDownLunch，又叫闭锁。它有三个关键的api：

new CountDownLatch(count); 创建一个闭锁，并声明count的值
countDownLatch.await(); 如果countDownLunch的count不是0，则阻塞当前线程直到count等0
countDownLatch.countDown();将countDownLunch中的count减一


17:16:02.329 [t1] INFO com.tulun.testCountDownLunch - [t1]在等待发令枪
17:16:03.341 [t2] INFO com.tulun.testCountDownLunch - [t2]在等待发令枪
17:16:04.354 [t3] INFO com.tulun.testCountDownLunch - [t3]在等待发令枪
17:16:05.368 [t4] INFO com.tulun.testCountDownLunch - [t4]在等待发令枪
17:16:06.378 [t5] INFO com.tulun.testCountDownLunch - [t5]在等待发令枪
17:16:07.380 [main] INFO com.tulun.testCountDownLunch - 开枪，开跑！
17:16:07.380 [t1] INFO com.tulun.testCountDownLunch - 枪响了,[t1]跑!
17:16:07.380 [t2] INFO com.tulun.testCountDownLunch - 枪响了,[t2]跑!
17:16:07.380 [t3] INFO com.tulun.testCountDownLunch - 枪响了,[t3]跑!
17:16:07.380 [t4] INFO com.tulun.testCountDownLunch - 枪响了,[t4]跑!
17:16:07.380 [t5] INFO com.tulun.testCountDownLunch - 枪响了,[t5]跑!

* */

public class testCountDownLunch {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(testCountDownLunch.class);

//创建一个count=1的闭锁
        CountDownLatch countDownLatch = new CountDownLatch(1);


        List<Thread> threads = new ArrayList<>();
//创建5个线程
        for (int i = 0; i < 5; i++) {
            //传入任务体
            Thread thread = new Thread(() -> {
                logger.info("[{}]在等待发令枪", Thread.currentThread().getName());
                try {
                    //会在count的值等于0时，唤醒被阻塞的线程，具体执行时间 要看CPU的调度，
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("枪响了,[{}]跑!", Thread.currentThread().getName());
            }, "t" + (i + 1));
            //   启动线程
            thread.start();
            //加入 线程 数组
            threads.add(thread);

            try {
                //让出CPU
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        logger.info("开枪，开跑！");
//将count--
        countDownLatch.countDown();
        try {
            //让出CPU（设置单位：秒）
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //循环等待  所有数组中线程结束
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




//            int count = 5;
//            CountDownLatch countDownLatch = new CountDownLatch(count);
//            String[] list = new String[count];
//            Random random = new Random();
//            // 循环count次，每次循环 创建一个线程
//            for (int i = 0; i < count; i++) {
//                int finalI = i;
//                Thread thread = new Thread(() -> {
//                    for (int j = 0; j <= 100; j++) {
//                        try {
//                            TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        list[finalI]= Thread.currentThread().getName()+"("+j+"%)";
//                        System.out.print("\r"+ Arrays.toString(list));
//                    }
//                    countDownLatch.countDown();
//                }, "t" + (i + 1));
//                thread.start();
//            }
//            try {
//                countDownLatch.await();//count减为0，主线程才能执行   注意是await
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.print("\n结束了");



    }
}
