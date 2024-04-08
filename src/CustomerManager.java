import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class CustomerManager {
    private List<Customer> customers;
    private static CustomerManager instance;

    private CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public static CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();
        }
        return instance;
    }

    public boolean containsCustomer(String id) {
        return instance.customers.stream().anyMatch(customer -> customer.getID().equals(id));
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(String id) {
        customers.removeIf(customer -> customer.getID().equals(id));
    }

    public Customer getCustomerByID(String id) {
        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Customer> getPolicyHolders() {
        List<Customer> policyHolders = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCustomerType().equals("1")) {
                policyHolders.add(customer);
            }
        }

        return policyHolders;
    }

    public List<Customer> getDependants() {
        List<Customer> dependants = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCustomerType().equals("2")) {
                dependants.add(customer);
            }
        }

        return dependants;
    }
}
