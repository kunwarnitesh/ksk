package com.ksk.concurrency;

public class ConcurrencyApplication {

    public static void main(String[] args) {
        Thread thread = new ThreadSample();
        thread.start();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Main: " + i);
//        }
    }

}

class ThreadSample extends Thread{
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("Inside Thread Sample "+i);
        }
    }
}

class RunnableSample implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("Inside Runnable Sample "+i);
        }
    }
}