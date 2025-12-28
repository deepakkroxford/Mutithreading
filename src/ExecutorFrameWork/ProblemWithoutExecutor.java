package ExecutorFrameWork;

class BankTransaction extends Thread {

    private int amount;

    BankTransaction(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println(
                "Processing amount " + amount +
                        " by " + Thread.currentThread().getName()
        );
    }
}
public class ProblemWithoutExecutor {
    public static void main(String[] args) throws InterruptedException {
//        BankTransaction t1 = new BankTransaction(10);
//        t1.start();

        /**
         * Creating 500 threads for 500 transactions is not efficient.
         * It can lead to high resource consumption and context switching overhead.
         * Instead, using a thread pool with a fixed number of threads would be more efficient.
         * This way, we can reuse a limited number of threads to handle multiple transactions,
         * reducing the overhead of thread creation and destruction.
         */


        /**
         * Main problem:
         * For every transaction, a new thread is created, and after completion it is destroyed.
         * There is no reuse of threads.
         */
        for (int i = 1; i <= 500; i++) {
            new BankTransaction(100).start();
        }
    }
}
