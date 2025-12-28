package DemonThreadConcept;

public class App {
    public static void main(String[] args) {
        Thread demonThread = new Thread(new DemonThread());
        Thread userThread = new Thread(new UserThread());
        demonThread.setDaemon(true);
        demonThread.start();
        userThread.start();
    }
}
