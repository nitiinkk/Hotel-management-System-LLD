import java.util.*;
public class Hotel {
    String name;
    HotelLocation location;
    List<HotelLocation> hotelLocationList = new ArrayList<>();
    Hotel(String name) {
        this.name = name;
    }

    public void addLocation(HotelLocation hotelLocation) {
        hotelLocationList.add(hotelLocation);
    }

    public void printDetails() {
        System.out.println("Hotel Locations ::");
        Iterator it = hotelLocationList.iterator();
        while(it.hasNext()) {
            HotelLocation loc = (HotelLocation) it.next();
            System.out.println(loc.printDetails());
        }
    }

}
