package DemonThreadConcept;

public class DemonThread implements  Runnable{

    @Override
    public void run() {
        int count = 0;
        while(count<500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            count = count+ 1;
            System.out.println("Demon thread is waiting......");
        }

    }
}
