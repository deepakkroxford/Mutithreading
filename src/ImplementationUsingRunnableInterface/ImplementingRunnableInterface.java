package ImplementationUsingRunnableInterface;

public class ImplementingRunnableInterface {
    public static void main(String[] args) {

        World world = new World();
        Thread thread1 = new Thread(world);

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("This is thread2 ");
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
