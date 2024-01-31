import java.util.Date;

public class HouseKeeping {
    String description;
    Date startDate;
    Integer duration;
    HouseKeeper houseKeeper;

    public void  setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date d) {
        this.startDate = d;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setHouseKeeper(HouseKeeper houseKeeper) {
        this.houseKeeper = houseKeeper;
    }

    public static HouseKeeping writeLog(HouseKeeper houseKeeper) {
        System.out.println("Room keeper assigned \n");
        HouseKeeping houseKeeping1 = new HouseKeeping();
        houseKeeping1.setHouseKeeper(houseKeeper);
        houseKeeping1.setDescription("cleaning room...");
        houseKeeping1.setStartDate(new Date());
        houseKeeping1.setDuration(30);
        return houseKeeping1;
    }
}
