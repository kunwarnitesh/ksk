package com.ksk.concurrency;

import org.springframework.boot.actuate.endpoint.web.Link;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueUtil {

    private Queue<Integer> queue = new LinkedList<>();
    private int MAX_CAPACITY = 0;

    public BlockingQueueUtil(int capacity){
        this.MAX_CAPACITY = capacity;
    }

    public synchronized void produced(int data) throws InterruptedException{

        while (queue.size() == MAX_CAPACITY){
            wait();;
        }
        queue.add(data);
        System.out.println("Produced :" + data);
        notify();
    }

    public synchronized void consume(int data) throws InterruptedException{
        while (queue.isEmpty()){
            wait();;
        }
        queue.poll();
        System.out.println("Consumed :" + data);
        notify();
    }



}
