package ThreadMethods;

public class Method2 extends Thread {
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.yield();
        }
    }
    public static void main(String[] args) {
        Method2 myMethod1 = new Method2();
        Method2 myMethod2 = new Method2();
        myMethod1.start();
        myMethod2.start();
    }
}
