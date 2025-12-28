package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 500;
    private Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "Trying to aquire lock");
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance > amount) {
                    System.out.println(Thread.currentThread().getName() + "Kindely Wait We are going to withdraw " + amount);
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " withdraw completed.");
                } else {
                    System.out.println(Thread.currentThread().getName() + "Insufficient balance.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "Could not acquire lock.");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }


    }
}
