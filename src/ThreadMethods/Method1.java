package ThreadMethods;

public class Method1 extends Thread {

    /**
     * using the constructor we can give the name of the thread by own choice
     */
    public Method1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<50;i++) {
            System.out.println("Name :- "+Thread.currentThread().getName() + " Priority :- " + Thread.currentThread().getPriority()
                    + " Count:- " + i);
            try {
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Method1 m1 = new Method1("High");
        m1.setPriority(Thread.MAX_PRIORITY);
        Method1 m2 = new Method1("Medium");
        m2.setPriority(Thread.NORM_PRIORITY);
        Method1 m3 = new Method1("Low");
        m3.setPriority(Thread.MIN_PRIORITY);
        m1.start();
        m2.start();
        m3.start();

        /**
         * learning -> setPriority, getPriority, sleep, getName(), settingName using the constructor
         */
    }
}
