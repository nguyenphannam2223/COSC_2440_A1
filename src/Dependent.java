public class Dependent extends Customer {
    public Dependent(String id, String fullName, String cardNumber, Customer mainCustomer) {
        super(id, fullName, cardNumber);
    }

    @Override
    public String getCustomerType() {
        return "Dependent";
    }
}