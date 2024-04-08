import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public abstract class Customer {
    private String id;
    private String fullName;
    private String cardNumber;
    private List<String> claims;

    public Customer(String id, String fullName, String cardNumber) {
        this.id = id;
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.claims = new ArrayList<>();
    }

    public String getID() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public List<String> getClaims() {
        return claims;
    }

    public void addClaim(String claim) {
        claims.add(claim);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setClaims(List<String> claims) {
        this.claims = claims;
    }

    public abstract String getCustomerType();

    public abstract String repr();

    @Override
    public String toString() {
        String type = getCustomerType().equals("1") ? "Policy Holder" : "Dependent";
        return String.format(Utils.CUSTOMER_RECORD_FORMAT, id, fullName, cardNumber, claims.size(), type);
    }
}