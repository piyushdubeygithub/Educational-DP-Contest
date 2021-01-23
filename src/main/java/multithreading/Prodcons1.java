package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prodcons1 {
    public static void main(String[] args) {
// shared queue created using LinkedBlockingQueue
         List<Integer> blockingQueue = Collections.synchronizedList(new ArrayList<>());
        // Producer thread creation
        Producer1 producer = new Producer1(blockingQueue);
        // Consumer thread creation
        Consumer1 consumer = new Consumer1(blockingQueue);

        // Start Producer and Consumer thread
        producer.start();
        consumer.start();
    }
}

class Producer1 extends Thread{
    private final List<Integer> blockingQueue;

    public Producer1(List<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void run() {
        for (int i = 0; i <= 50; i += 10) {
            try {
                Thread.sleep(1000);
                System.out.println(String.format("Producer produced data %s and added to queue.",i));
                blockingQueue.add(i);
            } catch (InterruptedException ex) {
                System.out.println("Producer thread is interrupted.");
            }
        }
    }
}

class Consumer1 extends Thread{
    private final List<Integer> blockingQueue;

    public Consumer1(List<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
                System.out.println(String.format("Consumer consumed data %s from queue.",blockingQueue.remove(blockingQueue.get(0))));
        }
    }
}