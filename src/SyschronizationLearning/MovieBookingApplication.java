package SyschronizationLearning;

public class MovieBookingApplication {

    public static void main(String[] args) {
        BookTheaterSeat bookTheaterSeat = new BookTheaterSeat();

        Thread t1 = new Thread(new BookingTask(bookTheaterSeat, 7));
        Thread t2 = new Thread(new BookingTask(bookTheaterSeat, 6));

        t1.start();
        t2.start();
    }
}
