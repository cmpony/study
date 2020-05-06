package juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(3);
        q.add("1");
        q.add("1");
        q.add("1");
        q.offer("1");
    }
}
