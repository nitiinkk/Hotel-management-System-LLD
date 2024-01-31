import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Guest extends Person implements Search {
    AccountType accountType;
    List<RoomBooking>roomBookingList = new ArrayList<>();
    Guest(String name, String email, String phone, AccountType accountType) {
        super(name, email, phone);
        this.accountType = accountType;
    }

    public int totalRoomsCheckedIn() {
        return roomBookingList.size();
    }

    @Override
    public List<Room> searchRoom(HotelLocation location, RoomStyle roomstyle, Date startDate, Integer duration) {
        System.out.println("Searching available rooms ...\n");
        List<Room>result = location.getAvailableRooms();
        List<Room>searchResult = new ArrayList<>();
            Iterator it = result.iterator();
            while(it.hasNext()) {
                Room room = (Room) it.next();
                if (room.isRoomAvailable() && room.checkRoomStyle(roomstyle)) {
                    System.out.println("Available Room for Guest -> Style: " + room.roomStyle + " roomId: " + room.roomNumber);
                    searchResult.add(room);
                }
            }
        return searchResult;
    }

    public RoomBooking checkIn(HotelLocation location, RoomStyle roomstyle, Date startDate, Integer duration) {
        List<Room> availableRooms = searchRoom(location, roomstyle, startDate, duration);
        if (availableRooms.size() > 0) {
            Room room = availableRooms.get(0);
            room.updateRoomStatus(RoomStatus.OCCUPIED);
            RoomBooking roomBooking1 = new RoomBooking(duration, room);
            roomBookingList.add(roomBooking1);
            room.checkIn();
            System.out.println("Successfully created room booking....\n");
            return roomBooking1;
        }
        System.out.println("No Booking can be made currently");
        return null;
    }

    public void checkOut(RoomBooking roomBooking) {
        roomBooking.setCheckOutTime(LocalTime.now());
        Room room = roomBooking.getBookingRoom();
        room.setAvailable();
        Invoice inv = roomBooking.getInvoice();
        Server.payBill(inv.getAmt());
        roomBooking.setBookingStatus(BookingStatus.CHECKED_OUT);
        roomBookingList.remove(roomBooking);
    }

    public void cancelBooking(RoomBooking roomBooking) {
        Room room = roomBooking.getBookingRoom();
        BookingStatus bs = roomBooking.setBookingStatus(BookingStatus.CANCELED);
        Double amt = room.getBookingPrice();
        room.setAvailable();
        roomBooking.setCheckOutTime(LocalTime.now());
        Server.notify(email, phone);
        Server.refund(amt, bs);
    }
}
