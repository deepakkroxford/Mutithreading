package SyschronizationLearning;

public class Main {
    public static void main(String[] args) {
        /**
         * Here the counter is a shared resource. And two Thread try to access one shared resource.
         * for preventing this we use synchronized key word and this synchronized key word is work like
         * a lock at a time only one thread can access the critical section. if the t1 have lock only t1
         * can access the resource , when t2 get lock then only t2 can access the resource...
         */
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(Exception e){
            e.printStackTrace();
        }

        /**
         * In this case we two thread accessing the same object and try to update there
         * value but it will give the wrong answer. so for getting the correct answer we
         * have to make the counter variable synchronize, it means that at a time only one
         * thread can access the value of the counter and try to update the value .
         *
         * So we can make the method synchronized or any block of code as per our requirement.
         */

        System.out.println(counter.getCounter());
    }
}
