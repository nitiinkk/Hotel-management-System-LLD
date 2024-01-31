import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

public class RoomBooking {
    String reservationNumber;
    Date startDate;
    Integer durationInDays;
    BookingStatus bookingStatus;
    Room room;
    LocalTime checkInTime;
    LocalTime checkoutTime;
    Invoice invoice;

    RoomBooking(Integer durationInDays, Room room) {
        this.reservationNumber = UUID.randomUUID().toString();
        this.startDate = new Date();
        this.checkInTime = LocalTime.now();
        this.bookingStatus = BookingStatus.CHECKED_IN;
        this.durationInDays = durationInDays;
        this.room = room;
        this.invoice = new Invoice();
    }

    public Room getBookingRoom() {
        return this.room;
    }

    public void setCheckOutTime(LocalTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public LocalTime getCheckOutTime() {
        return this.checkoutTime;
    }

    public LocalTime getCheckInTime() {
        return this.checkInTime;
    }

    public Invoice getInvoice() {
        invoice.createBill(room.getBookingPrice());
        return invoice;
    }

    public BookingStatus setBookingStatus(BookingStatus bs) {
        this.bookingStatus = bs;
        return bookingStatus;
    }

}
