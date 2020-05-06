package lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res {
    public String userName;
    public String sex;
    public boolean flag  = false;
    Lock lock = new ReentrantLock();
}

class Out extends Thread {
    Res res;
    Condition newCondition;
    public Out (Res res, Condition newCondition) {
        this.res = res;
        this.newCondition = newCondition;
    }
    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                res.lock.lock();
                if (res.flag) {
                    try {
                        newCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.userName = "小红";
                    res.sex = "女";
                } else {
                    res.userName = "hello Mr.";
                    res.sex = "男";
                }
                count = (count + 1) % 2;
                res.flag = true;
                newCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

class Input extends Thread {
    Res res;
    Condition newCondition;
    public Input (Res res, Condition newCondition) {
        this.res = res;
        this.newCondition = newCondition;
    }
    @Override
    public void run() {
        while (true) {
            try {
                res.lock.lock();
                if (!res.flag) {
                    try {
                        newCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userName + "," + res.sex);
                res.flag = false;
                newCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

public class OutInputThread {
    public static void main(String[] args) {
        Res res = new Res();
        Condition condition = res.lock.newCondition();
        Out out = new Out(res, condition);
        Input input = new Input(res, condition);
        out.start();
        input.start();
    }
}
