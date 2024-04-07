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

    public String getId() {
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


    public abstract String getCustomerType();
}
