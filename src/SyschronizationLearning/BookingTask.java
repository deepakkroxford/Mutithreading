package SyschronizationLearning;

public class BookingTask implements Runnable {

    private BookTheaterSeat bookTheaterSeat;
    private int seats;

    public BookingTask(BookTheaterSeat bookTheaterSeat, int seats) {
        this.bookTheaterSeat = bookTheaterSeat;
        this.seats = seats;
    }

    @Override
    public void run() {
        bookTheaterSeat.bookSeat(seats);
    }
}
