package com.ksk.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadCommunication {

    private static final BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        new Thread(() -> produceData()).start();
        new Thread(() -> consumeData()).start();
    }

    private static void produceData() {
        // Produce data and put it in the queue
        sharedQueue.offer(1);
    }

    private static void consumeData() {
        try {
            // Consume data from the queue
            Integer data = sharedQueue.take();
            System.out.println("Consumed: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
