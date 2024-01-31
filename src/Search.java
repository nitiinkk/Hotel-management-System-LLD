import java.util.Date;
import java.util.List;

public interface Search {

    public List<Room> searchRoom(HotelLocation location, RoomStyle roomstyle, Date startDate, Integer duration);
}
