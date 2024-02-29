package com.ksk.concurrency;

public class ProducerThread implements Runnable{

    private BlockingQueueUtil blockingQueueUtil;

    public ProducerThread(BlockingQueueUtil blockingQueueUtil){
        this.blockingQueueUtil = blockingQueueUtil;
    }
    @Override
    public void run() {
       for (int i=0;i< 10;i++){
           try {
               blockingQueueUtil.produced(i);
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}
