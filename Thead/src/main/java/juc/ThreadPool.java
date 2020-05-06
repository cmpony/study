package juc;

import java.util.Vector;
import java.util.concurrent.*;

/**
 * 线程池配置多少合适
 * cpu密集
 * io密集
 */

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute( () -> {
                System.out.println(Thread.currentThread().getName()+",i:"+ finalI);
            });
        }
        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            scheduledExecutorService.schedule(()->{
                System.out.println(Thread.currentThread().getName()+",i:"+ finalI);
            },3L, TimeUnit.SECONDS);
        }

        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

    }
}
