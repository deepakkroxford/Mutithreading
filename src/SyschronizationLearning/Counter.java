package SyschronizationLearning;

public class Counter {
    private int counter = 0;

    /**
     * So the increment is not synchronized so it means that when
     * two thread try to access this block of code it will not update the
     * value propery.
     */
//    public void increment() {
//        counter++;
//    }

    public synchronized void increment() {
        counter++;
    }

    /** we can also do this
     * public void increment() {
     *     synchronized{
     *         counter++;
     *     }
     * }
     *
     */

    public int getCounter() {
        return counter;
    }
}
