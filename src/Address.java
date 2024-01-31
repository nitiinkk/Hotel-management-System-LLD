public class Address {
    String street;
    String state;
    String country;
    Integer pincode;

    Address(String street, String state, String country, Integer pincode) {
        this.street = street;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public String printDetails() {
        return street + "," + state + "," + country + "," + pincode;
    }
}
