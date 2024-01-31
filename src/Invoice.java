public class Invoice {
    double amount  = 200;
    public void createBill(Double extraPay) {
        this.amount+=extraPay;
    }

    public Double getAmt() {
        return amount;
    }
}
