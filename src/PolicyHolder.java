import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class PolicyHolder extends Customer {
    private List<String> dependents;

    public PolicyHolder(String id, String fullName, String cardNumber) {
        super(id, fullName, cardNumber);
        this.dependents = new ArrayList<>();
    }

    public List<String> getDependents() {
        return dependents;
    }

    public void addDependent(String dependent) {
        dependents.add(dependent);
    }

    @Override
    public String getCustomerType() {
        return "Policy Holder";
    }
}
