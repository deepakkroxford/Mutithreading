package ThreadMethods;

public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=500;i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=500;i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });

        t1.start();
        t1.join();   // wait for t1
        t2.start();  // start t2 after t1 finishes/
        /**
         * until the execution of thread 1 the main thread wait for it.
         */
        System.out.println("main thread end");


    }
}
