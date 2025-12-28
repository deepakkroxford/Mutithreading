package Lock;

public class Main {
    public static void main(String[] args) {
        BankAccount  sbi = new BankAccount();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };

        Thread t1 = new Thread(r1," t1 ");
        Thread t2 = new Thread(r1," t2 ");
        t1.start();
        t2.start();
    }
}
