package ImplementationUsingRunnableInterface;

public class World implements Runnable {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Hello World!" + Thread.currentThread().getName());
        }
    }
}
