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
        return instance.customers.stream().anyMatch(customer -> customer.getId().equals(id));
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(String id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }

    public Customer getCustomerByID(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
