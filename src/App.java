public class App {
    private static CustomerManager customerManager = new CustomerManager();
    private static ClaimProcessManager claimProcessManager = new ClaimProcessManager();
    private static CardManager cardManager = new CardManager();

    private static void addCustomer() {
        String ID = Utils.readCustomerID();
        if (customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Enter customer full name: ");
        String fullName = Utils.readString();

        int choice = 0;
        do {
            System.out.println("1. Add a policy holder");
            System.out.println("2. Add a dependent");
            System.out.print("Enter your choice: ");
            choice = Utils.readInt();
        } while (choice != 1 && choice != 2);

        Customer customer = null;

        if (choice == 1) {
            customer = new PolicyHolder(ID, fullName, null);
        } else {
            customer = new Dependent(ID, fullName, null);
        }

        customerManager.addCustomer(customer);
    }

    private static void removeCustomer() {
        System.out.print("Enter customer ID: ");
        String ID = Utils.readString();

        if (!customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID does not exist.");
            return;
        }

        customerManager.removeCustomer(ID);
    }

    private static void updateCustomer() {
        System.out.print("Enter customer ID: ");
        String ID = Utils.readString();

        if (!customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID does not exist.");
            return;
        }

        System.out.print("Enter new full name: ");
        String fullName = Utils.readString();

        Customer customer = customerManager.getCustomerByID(ID);
        customer.setFullName(fullName);
    }

    private static void displayAllCustomers() {
        System.out.printf(Utils.CUSTOMER_HEADER_FORMAT, "ID", "Full Name", "Card Number", "Number of Claims");
        for (Customer customer : customerManager.getCustomers()) {
            System.out.println(customer);
        }
    }

    private static void findCustomer() {
        System.out.print("Enter customer ID: ");
        String ID = Utils.readCustomerID();

        if (!customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID does not exist.");
            return;
        }

        Customer customer = customerManager.getCustomerByID(ID);
        System.out.println(customer);
    }

    private static void customerMenu() {
        System.out.println("1. Add a new customer");
        System.out.println("2. Remove a customer");
        System.out.println("3. Update a customer");
        System.out.println("4. Display all customers");
        System.out.println("5. Find customer");
        System.out.println("0. Back to main menu");
    }

    private static void manageCustomer() {
        int choice = 0;

        do {
            customerMenu();
            System.out.print("Enter your choice: ");
            choice = Utils.readInt();
            System.out.println();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    displayAllCustomers();
                    break;
                case 5:
                    findCustomer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("InvalID choice.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void manageCards() {
    }

    private static void manageClaims() {
    }

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("1. Manage customers");
            System.out.println("2. Manage cards");
            System.out.println("3. Manage claims");
            System.out.print("Enter your choice: ");
            choice = Utils.readInt();
            System.out.println();

            switch (choice) {
                case 1:
                    manageCustomer();
                    break;
                case 2:
                    manageCards();
                    break;
                case 3:
                    manageClaims();
                    break;
                default:
                    System.out.println("InvalID choice.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
}
