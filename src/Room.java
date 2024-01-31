import java.util.ArrayList;
import java.util.List;

public class Room {
    Integer roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    double bookingPrice;
    boolean isSmoking;
    List<RoomKey> roomKeyList = new ArrayList<>();
    List<HouseKeeping>houseKeepingLogs = new ArrayList<>();
    HouseKeeper houseKeeper;

    Room(RoomStyle roomStyle) {
        if(roomStyle == RoomStyle.DELUXE) {
            this.isSmoking = true;
            this.bookingPrice = 1000;
            this.roomStyle = roomStyle;
        } else if(roomStyle == RoomStyle.FAMILY_SUITE) {
            this.isSmoking = false;
            this.bookingPrice = 700;
            this.roomStyle = roomStyle;
        } else {
            this.isSmoking = false;
            this.bookingPrice = 300;
            this.roomStyle = roomStyle;
        }
        this.roomStatus = RoomStatus.AVAILABLE;
        this.roomNumber = 1;
        this.houseKeeper = new HouseKeeper("nitin", "n@gmail.com", "123", AccountType.STAFF);
        RoomKey key1 = new RoomKey();
        roomKeyList.add(key1);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public boolean isRoomAvailable() {
        if(roomStatus.equals(RoomStatus.AVAILABLE)) return true;
        return false;
    }

    public void setAvailable() {
        this.roomStatus = roomStatus.AVAILABLE;
    }

    public boolean checkRoomStyle(RoomStyle roomStyle) {
        if(this.roomStyle ==  roomStyle) return true;
        return false;
    }

    public void updateRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public boolean checkIn() {
        if(roomStatus.equals(roomStatus.AVAILABLE)) {
            roomStatus = roomStatus.OCCUPIED;
            houseKeepingLogs.add(houseKeeper.doHouseKeeping());
            System.out.println("Key of the room " + roomKeyList.get(0).assignRoom());
            return true;
        }
        return false;
    }

    public boolean checkOut() {
        roomStatus = roomStatus.AVAILABLE;
        return true;
    }

    public double getBookingPrice() {
        return this.bookingPrice;
    }

}
