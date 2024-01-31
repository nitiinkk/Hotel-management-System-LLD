import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hotel Management System");
        Address address = new Address("Sardar Patel Marg", "New Delhi", "India", 110021);
        Address address2 = new Address("Near IndiaGate", "Mumbai", "India", 110045);
        Hotel hotel = new Hotel("The Taj");
        HotelLocation locationDelhi = new HotelLocation(address);
        HotelLocation locationMumbai = new HotelLocation(address2);
        hotel.addLocation(locationDelhi);
        hotel.addLocation(locationMumbai);
        hotel.printDetails();
        locationDelhi.getAvailableRooms();

        Guest g1 = new Guest("Guest", "guest@gmail.com", "1234", AccountType.GUEST);
        Guest g2 = new Guest("Guest2", "guest2@gmail.com", "0038", AccountType.GUEST);
        RoomBooking bookingId1 =  g1.checkIn(locationDelhi, RoomStyle.DELUXE, new Date(), 2);
        RoomBooking bookingId2 = g2.checkIn(locationDelhi, RoomStyle.STANDARD, new Date(), 2);
        g2.cancelBooking(bookingId2);
        g1.checkOut(bookingId2);

    }
}