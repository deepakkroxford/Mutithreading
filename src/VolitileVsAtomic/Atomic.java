package VolitileVsAtomic;


import java.util.concurrent.atomic.AtomicInteger;

class Counter {
   volatile int counter;
   // Here after putting volatile keyword the value of counter will be wrong after accessing by
    // two thread because volatile only make sure that the value is read from main memory
    // but it will not make the operation atomic. so for making the operation atomic we have to use
    // AtomicInteger class from java.util.concurrent.atomic package.


    // It make the shared variable operation atomic or thread safe.
    AtomicInteger atomicInteger  = new AtomicInteger(0);

    public void   increment() {
        //counter++;
        atomicInteger.incrementAndGet();
    }

    public int getCounter() {
       // return counter;
        return atomicInteger.get();
    }
}
public class Atomic {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCounter());
    }
}
