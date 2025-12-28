package SyschronizationLearning.InterThreadCommunication;

import java.util.LinkedList;
import java.util.Queue;


/**
 * In this class we will implement the producer consumer problem using wait and notify methods
 * we will have a queue with a fixed capacity
 * the producer will produce items and add them to the queue
 * the consumer will consume items from the queue
 * if the queue is full the producer will wait
 * if the queue is empty the consumer will wait
 *
 * Problem In this approach is we have to manually handle the wait and notify methods
 * if we forget to call notify method the other thread will be in waiting state forever
 * so to avoid this problem we can use the BlockingQueue class in java which internally
 */
public class ProducerAndConsumer {
    int capacity;
    Queue<Integer> queue = new LinkedList<>();
    public ProducerAndConsumer(int capacity) {
        this.capacity = capacity;
    }

    // now i have to define the produce and consume methods

    public synchronized void produce(int value) throws InterruptedException {
        // first check if the queue is full
        while (queue.size() == capacity) {
            wait(); // wait until there is space in the queue
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notify(); // notify the consumer that an item has been produced
    }

    public synchronized Integer consume() throws InterruptedException {
        while(queue.isEmpty()) {
            wait(); // wait until there is an item to consume
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notify(); // notify the producer that an item has been consumed
        return value;
    }
}
