package ImplementationUsingThreadClass;

public class World extends Thread{
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("running the world");
        }
    }
}
