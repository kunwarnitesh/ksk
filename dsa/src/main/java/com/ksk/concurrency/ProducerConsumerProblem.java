package com.ksk.concurrency;

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        BlockingQueueUtil blockingQueueUtil = new BlockingQueueUtil(3);
           new Thread(new ProducerThread(blockingQueueUtil)).start();
           new Thread(new ConsumerThread(blockingQueueUtil)).start();
    }
}
