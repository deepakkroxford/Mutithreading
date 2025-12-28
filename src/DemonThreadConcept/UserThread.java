package DemonThreadConcept;

public class UserThread implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(9000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("user thread start");
    }
}
