public class HouseKeeper extends Person {
    AccountType accountType;
    public HouseKeeper(String name, String email, String phone, AccountType accountType) {
        super(name, email, phone);
        this.accountType = accountType;
    }

    public HouseKeeping doHouseKeeping() {
        return HouseKeeping.writeLog(this);
    }
}
