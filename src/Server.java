public class Server extends Person {
    AccountType accountType;
    Server(String name, String email, String phone, AccountType accountType) {
        super(name, email, phone);
        this.accountType = accountType;
    }

    public static void notify(String email, String phone) {
        System.out.println("Refund Intiated to "+ email + " and over sms to "+ phone);
    }

    public static void refund(Double amt, BookingStatus bs) {
        if(bs.equals(BookingStatus.CANCELED)) {
            System.out.println("Refunded Amt : " + "$" + amt);
        }
    }

    public static void payBill(Double billAmt) {
        System.out.println("Bill Amount payed successfully $"+ billAmt);
    }
}
