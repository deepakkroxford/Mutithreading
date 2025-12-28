package SyschronizationLearning;

public class BookTheaterSeat {
    private int totalSeats = 10;

    // This is method level synchronization
//    public synchronized void  bookSeat(int seats) {
//        if(totalSeats >= seats) {
//            System.out.println("Seat booked successfully");
//            totalSeats = totalSeats - seats;
//            System.out.println("Seats left: " + totalSeats);
//        } else {
//            System.out.println("Sorry seats not available");
//            System.out.println("Seats left: " + totalSeats);
//        }
//    }

    // This is block level synchronization where we are synchronizing only the critical section
    public  void  bookSeat(int seats) {
        synchronized (this) {
            if (totalSeats >= seats) {
                System.out.println("Seat booked successfully");
                totalSeats = totalSeats - seats;
                System.out.println("Seats left: " + totalSeats);
            } else {
                System.out.println("Sorry seats not available");
                System.out.println("Seats left: " + totalSeats);
            }
        }
    }


}
