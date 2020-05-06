package ex1;

class ThreadTrain1 implements Runnable {
    private int train1Count = 100;

    private final Object ob = new Object();

    @Override
    public void run() {
        while (train1Count > 0) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
            sale();
        }
    }

    public void sale() {
        synchronized (ob) {
            if (train1Count > 0) {
                System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - train1Count + 1) + "票");
                train1Count--;
            }
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        ThreadTrain1 threadTrain1 = new ThreadTrain1();
        Thread t1 = new Thread(threadTrain1, "窗口①");
        Thread t2 = new Thread(threadTrain1, "窗口②");
        t1.start();
        t2.start();

    }
}
