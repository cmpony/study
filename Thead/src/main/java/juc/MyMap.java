package juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class MyMap {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        new Thread( () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
            cdl.countDown();
        }).start();
        new Thread( () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
            cdl.countDown();
        }).start();

        cdl.await();
        System.out.println(Thread.currentThread().getName() + "主线程开始");
    }
}
