package ex1;

import java.util.Queue;

class ThreadTrain2 implements Runnable {
    private int total;
    private int train1Count;

    public ThreadTrain2(int count) {
        this.train1Count = count;
        this.total = count;
    }

    @Override
    public void run() {
        while (train1Count > 0) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public synchronized void sale() {
        if (train1Count > 0) {
            System.out.println(Thread.currentThread().getName() + "，出售第" + (total - train1Count + 1) + "票");
            train1Count--;
        }
    }
}


public class ThreadDemo2 {
    public static void main(String[] args) {
        ThreadTrain2 threadTrain1 = new ThreadTrain2(100);
        Thread t1 = new Thread(threadTrain1, "微信支付窗口1");
        Thread t2 = new Thread(threadTrain1, "微信支付窗口2");
        t1.start();
        t2.start();

    }
}
