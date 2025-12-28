package SyschronizationLearning.InterThreadCommunication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        /**
         * We always use the put() method to add an item to the queue.
         * If the queue is full, the put() method blocks the producer thread until space becomes available.
         * If we used the add() method instead, it would throw an IllegalStateException when the queue is full.
         * Similarly, we use the take() method to remove an item from the queue.
         * If the queue is empty, the take() method blocks the consumer thread until an item becomes available.
         * If we used the remove() method instead, it would throw a NoSuchElementException when the queue is empty.
         */
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producing: " + i);
                    queue.put(i); // Blocks if the queue is full
                    Thread.sleep(100); // Simulate time taken to produce
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(()->{
            try {
                for (int i = 1; i <= 10; i++) {
                    Integer value = queue.take(); // Blocks if the queue is empty
                    System.out.println("Consuming: " + value);
                    Thread.sleep(150); // Simulate time taken to consume
                }
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
