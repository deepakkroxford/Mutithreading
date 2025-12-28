package ExecutorFrameWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicketBooking implements  Runnable {

    private int userId;

    TicketBooking(int userId) {
        this.userId = userId;
    }

    public void run() {
        System.out.println(
                "Booking ticket for User-" + userId +
                        " handled by " + Thread.currentThread().getName()
        );


    }
}

public class SolutionWithExecutor {
    public static void main(String[] args) {

        /**
         * Here we are using Executor framework to handle multiple threads.
         * We create a thread pool of fixed size and reuse the threads to handle multiple tasks.
         *
         *In this approch
         *  we only create 10 threads and reuse them for 200 ticket bookings.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 200; i++) {
            executorService.submit(new TicketBooking(i));
        }
        executorService.shutdown();

        // not good practice but still works
//        Executor executor = Executors.newFixedThreadPool(10);
//        for (int i = 1; i <= 200; i++) {
//            executor.execute(new TicketBooking(i));
//        }

    }
}
