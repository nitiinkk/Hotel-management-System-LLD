import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class HotelLocation {
    Integer id;
    Address address;
    List<Room> roomList = new ArrayList<>();


    HotelLocation(Address address) {
        this.id = 1;
        this.address = address;
        Room deluxeRoom = new Room(RoomStyle.DELUXE);
        roomList.add(deluxeRoom);
        Room room2 = new Room(RoomStyle.STANDARD);
        roomList.add(room2);
    }


    public List<Room> getAvailableRooms() {
        List<Room>availableRoomList = new ArrayList<>();
        Iterator it = roomList.iterator();
        while(it.hasNext()) {
            Room room = (Room) it.next();
            if(room.isRoomAvailable()) {
                System.out.println("Style: " + room.roomStyle + " roomId: " + room.roomNumber);
                availableRoomList.add(room);
            }
        }
        return availableRoomList;
    }

    public Room searchByRoomNumber(Integer targetRoomNumber) {
        Iterator it = roomList.iterator();
        while(it.hasNext()) {
            Room currentRoom = (Room)it.next();
            if(currentRoom.getRoomNumber().equals(targetRoomNumber)) {
                return currentRoom;
            }
        }
        System.out.println("No Room found with this " + targetRoomNumber);
        return null;
    }

    public String printDetails() {
        return address.printDetails();
    }
}
