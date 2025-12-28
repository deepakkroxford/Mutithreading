package ThreadStates;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        /**
         * We will get Output as New
         */
        System.out.println("State after creation (NEW): " + myThread.getState());

        myThread.start();

        /**
         * After starting the Thread we get the output as Runnable.
         */
        System.out.println("State after start (RUNNABLE or RUNNING): " + myThread.getState());

        /**
         *  It means that we are telling the main thread to wait for
         *  200 milli seceonds.
         */
        Thread.sleep(200);

        /**
         * So after putting the thread the sleep method in run method
         * now it goes in to timed_waiting state.
         */
        System.out.println("State while sleeping (TIMED_WAITING): " + myThread.getState());
        /**
         * It means that first complete the myThread then try to execute the main thread.
         */
        myThread.join();
        System.out.println("State after completion (TERMINATED): " + myThread.getState());



    }
}
