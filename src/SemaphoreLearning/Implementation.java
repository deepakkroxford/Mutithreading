package SemaphoreLearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Resource {
    public static final Semaphore semaphore = new Semaphore(3);

    public void accessResource(String threadName) {
        try {
            semaphore.acquire();   // take one permit
            System.out.println(threadName + " acquired a resource");

            // Simulate using resource
            Thread.sleep(3000);
            System.out.println(threadName + " releasing resource");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();  // return permit
        }
    }
}


public class Implementation {
    public static void main(String[] args) {
        Resource resource = new Resource();


        /**
         * Benefits of using the newCachedThreadPool is it create the thread dynamically.
         * It start from 0 thread and it create the new thred based on the requirement.
         * If create thread are ideal for 60 sec it destroyed it.
         */
//        try(ExecutorService executorService = Executors.newCachedThreadPool()) {
//            for(int i = 0; i < 10; i++) {
//                int id = i;
//                executorService.execute(()-> {
//                   resource.accessResource("Task" + id);
//                });
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i <= 20; i++) {
            int id = i;
            executorService.execute(() -> {
                resource.accessResource("Task -> " + id);
            });
        }
        executorService.shutdown();

        /**
         * What EXACTLY happens?
         *  Threads vs Resources
         *
         * 6 threads are created by the thread pool
         *
         * 3 permits exist in the semaphore
         *
         * All 6 threads may try to acquire the resource,
         * but only 3 succeed at the same time.
         */
        }
}
