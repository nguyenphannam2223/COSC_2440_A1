/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class Dependent extends Customer {
    public Dependent(String id, String fullName, String cardNumber) {
        super(id, fullName, cardNumber);
    }

    @Override
    public String getCustomerType() {
        return "2";
    }

    @Override
    public String repr() {
        return "Dependent\n"
                + "ID: " + getID() + "\n"
                + "Full Name: " + getFullName() + "\n"
                + "Card Number: " + getCardNumber() + "\n"
                + "Claims: " + getClaims();
    }
}
