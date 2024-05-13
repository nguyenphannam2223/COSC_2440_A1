//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers = new ArrayList();

    public CustomerManager() {
    }

    public boolean containsCustomer(String id) {
        Iterator var3 = this.customers.iterator();

        while(var3.hasNext()) {
            Customer customer = (Customer)var3.next();
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        nam123
        return false;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(String id) {
        this.customers.removeIf((customer) -> {
            return customer.getId().equals(id);
        });
    }

    public Customer getCustomerById(String id) {
        Iterator var3 = this.customers.iterator();

        while(var3.hasNext()) {
            Customer customer = (Customer)var3.next();
            if (customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }
}
