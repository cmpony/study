package juc;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 基于计数信号量
 */

class Parent extends Thread {
    Semaphore wc;
    String name;

    public Parent(Semaphore wc, String name) {
        this.wc = wc;
        this.name = name;
    }

    @Override
    public void run() {
        int availablePermits = wc.availablePermits();
        if (availablePermits > 0) {
            System.out.println(name + "有坑位");
        } else {
            System.out.println(name + "已经满了");
        }
        try {
            wc.acquire();
            System.out.println(name + "上厕所ing");
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(name + "上完了");
            wc.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreTest {


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Parent(semaphore, "第" + i + "个,").start();
        }
    }
}
