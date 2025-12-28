package ImplementationUsingThreadClass;

/**
 * This is the first way to create the thread in java.
 * So we can extend the thread class and override the  run method
 * and perform the operation.
 */
public class ExtendingThreadClass {
    public static void main(String[] args) {
        World world = new World();
        world.start(); // it means we start the thread

        // this is the main method thread
        for (int i=0;i<50;i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
