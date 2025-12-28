package VolitileVsAtomic;

class SharedResource {
    boolean flag = false;
  //make it volatile to solve the problem => volitile boolean flag = false;
    public void setFlag() {
        System.out.println("Setting flag to true");
        flag = true;
    }

    public void waitForFlag() {
        System.out.println("Waiting for flag...");
        while (!flag) {
            // busy-wait (may run forever)
        }
        System.out.println("Flag is true now");
    }

}



public class VolitileExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        /**
         * In this example, the reader thread may never see the updated value of 'flag' set by the writer thread
         * because 'flag' is not declared as volatile. As a result, the reader thread may keep reading the cached
         * value of 'flag' indefinitely,
         * leading to a situation where it appears to be stuck in the while loop.
         *
         *
         * So this problem rises because the thread uses the cached value of the variable instead of reading it from the main memory.
         * To solve this problem we can use the volatile keyword.
         */
        Thread readerThread = new Thread(() -> {
            sharedResource.waitForFlag();
        });

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedResource.setFlag();
        });

        readerThread.start();
        writerThread.start();
    }
}
