import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class App {
    private static CustomerManager customerManager = CustomerManager.getInstance();
    private static ClaimProcessManager claimProcessManager = ClaimProcessManager.getInstance();
    private static CardManager cardManager = CardManager.getInstance();

    // Customer Management
    private static void storeCustomer() {
        PrintWriter writer = Utils.getFileWriter("customers.csv");
        for (Customer customer : customerManager.getCustomers()) {
            writer.printf("%s,%s,%s,%s\n", customer.getID(), customer.getFullName(), customer.getCardNumber(),
                    customer.getCustomerType(),
                    String.join(";", customer.getClaims()));
        }

        writer.close();
    }

    private static void readCustomer() {
        Scanner fileReader = Utils.getFileReader("customers.csv");
        while (fileReader.hasNextLine()) {
            String[] data = fileReader.nextLine().split(",");
            String ID = data[0];
            String fullName = data[1];
            String cardNumber = data[2];
            int customerType = Integer.parseInt(data[3]);
            Customer customer = null;

            if (customerType == 1) {
                customer = new PolicyHolder(ID, fullName, cardNumber);
            } else {
                customer = new Dependent(ID, fullName, cardNumber);
            }

            if (data.length == 5) {
                String[] claims = data[4].split(";");
                for (String claim : claims) {
                    customer.addClaim(claim);
                }
            }

            customerManager.addCustomer(customer);
        }
    }

    private static void customerMenu() {
        System.out.println("1. Add a new policy holder");
        System.out.println("2. Add a new dependent");
        System.out.println("3. Remove a customer");
        System.out.println("4. Update a customer");
        System.out.println("5. Display all customers");
        System.out.println("6. Find customer");
        System.out.println("0. Back to main menu");
    }

    private static void addPolicyHolder() {
        String ID = Utils.readCustomerID("Enter holder ID: ");
        if (customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Enter customer full name: ");
        String fullName = Utils.readString();

        Customer customer = null;
        customer = new PolicyHolder(ID, fullName, null);

        customerManager.addCustomer(customer);
        System.out.printf("Customer %s added successfully.\n", ID);
    }

    private static void addDependent() {
        String ID = Utils.readCustomerID("Enter holder ID: ");
        while (!customerManager.containsCustomer(ID)
                || customerManager.getCustomerByID(ID).getCustomerType().equals("2")) {
            System.out.println("Customer ID already exists or not a holder.");
            ID = Utils.readCustomerID("Enter holder ID: ");
        }

        String dependentID = Utils.readCustomerID("Enter dependent ID: ");

        System.out.print("Enter dependant full name: ");
        String fullName = Utils.readString();

        Customer dependant = null;
        dependant = new Dependent(dependentID, fullName, null);

        ((PolicyHolder)customerManager.getCustomerByID(ID)).addDependent(dependentID);
        customerManager.addCustomer(dependant);

        System.out.printf("Customer %s added successfully.\n", dependentID);
    }

    private static void removeCustomer() {
        String ID = Utils.readCustomerID("Enter customer ID: ");

        if (!customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID does not exist.");
            return;
        }

        customerManager.removeCustomer(ID);
        System.out.printf("Customer %s removed successfully.\n", ID);
    }

    private static void updateCustomer() {
        String ID = Utils.readCustomerID("Enter customer ID: ");

        if (!customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID does not exist.");
            return;
        }

        System.out.print("Enter new full name: ");
        String fullName = Utils.readString();

        Customer customer = customerManager.getCustomerByID(ID);
        customer.setFullName(fullName);
        System.out.printf("Customer %s updated successfully.\n", ID);
    }

    private static void displayAllCustomers() {
        System.out.printf(Utils.CUSTOMER_HEADER_FORMAT, "ID", "Full Name", "Card Number", "Number of Claims",
                "Customer Type");
        for (Customer customer : customerManager.getCustomers()) {
            System.out.print(customer);
        }
    }

    private static void findCustomer() {
        String ID = Utils.readCustomerID("Enter customer ID: ");

        if (!customerManager.containsCustomer(ID)) {
            System.out.println("Customer ID does not exist.");
            return;
        }

        Customer customer = customerManager.getCustomerByID(ID);
        System.out.println(customer.repr());
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
                    addPolicyHolder();
                    break;
                case 2:
                    addDependent();
                    break;
                case 3:
                    removeCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    displayAllCustomers();
                    break;
                case 6:
                    findCustomer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
    // End of Customer Management

    // Card Management
    private static void storeCard() {
        PrintWriter writer = Utils.getFileWriter(Utils.INSURANCE_DATA_FILE);
        for (InsuranceCard card : cardManager.getCards()) {
            writer.printf("%s,%s,%s,%s\n", card.getCardNumber(), card.getHolderID(), card.getOwnerID(),
                    card.getExpirationDate());
        }

        writer.close();
    }

    private static void readCard() {
        Scanner fileReader = Utils.getFileReader(Utils.INSURANCE_DATA_FILE);
        while (fileReader.hasNextLine()) {
            String[] data = fileReader.nextLine().split(",");
            String cardNumber = data[0];
            String holderID = data[1];
            String ownerID = data[2];
            LocalDate expirationDate = LocalDate.parse(data[3]);
            InsuranceCard card = new InsuranceCard(cardNumber, holderID, ownerID, expirationDate);
            cardManager.addCard(card);
        }
    }

    private static void cardMenu() {
        System.out.println("1. Add a new card");
        System.out.println("2. Remove a card");
        System.out.println("3. Update a card");
        System.out.println("4. Display all cards");
        System.out.println("5. Find card");
        System.out.println("0. Back to main menu");
    }

    private static void addCard() {
        String cardNumber = Utils.readInsuranceCardNumber();
        if (cardManager.containsCard(cardNumber)) {
            System.out.println("Card number already exists.");
            return;
        }

        String holderID = Utils.readCustomerID("Enter holder ID: ");
        while (!customerManager.containsCustomer(holderID)) {
            System.out.println("Holder ID does not exist.");
            holderID = Utils.readCustomerID("Enter holder ID: ");
        }

        String ownerID = Utils.readCustomerID("Enter owner ID: ");
        while (!customerManager.containsCustomer(ownerID)) {
            System.out.println("Owner ID does not exist.");
            ownerID = Utils.readCustomerID("Enter owner ID: ");
        }

        LocalDate expirationDate = Utils.readDate();

        InsuranceCard card = new InsuranceCard(cardNumber, holderID, ownerID, expirationDate);
        cardManager.addCard(card);

        System.out.printf("Card %s added successfully.\n", cardNumber);
    }

    private static void removeCard() {
        System.out.print("Enter card number: ");
        String cardNumber = Utils.readString();

        if (!cardManager.containsCard(cardNumber)) {
            System.out.println("Card number does not exist.");
            return;
        }

        cardManager.removeCard(cardNumber);
        System.out.printf("Card %s removed successfully.\n", cardNumber);
    }

    private static void updateCard() {
        System.out.print("Enter card number: ");
        String cardNumber = Utils.readString();

        if (!cardManager.containsCard(cardNumber)) {
            System.out.println("Card number does not exist.");
            return;
        }

        System.out.print("Enter new holder ID: ");
        String holderID = Utils.readCustomerID("Enter customer ID: ");

        System.out.print("Enter new owner ID: ");
        String ownerID = Utils.readCustomerID("Enter customer ID: ");

        InsuranceCard card = cardManager.getCardByNumber(cardNumber);
        card.setHolderID(holderID);
        card.setOwnerID(ownerID);
        System.out.printf("Card %s updated successfully.\n", cardNumber);
    }

    private static void displayAllCards() {
        System.out.printf(Utils.CARD_HEADER_FORMAT, "Card Number", "Holder ID", "Owner ID", "Expiration Date");
        for (InsuranceCard card : cardManager.getCards()) {
            System.out.println(card);
        }
    }

    private static void findCard() {
        String cardNumber = Utils.readInsuranceCardNumber();

        if (!cardManager.containsCard(cardNumber)) {
            System.out.println("Card number does not exist.");
            return;
        }

        InsuranceCard card = cardManager.getCardByNumber(cardNumber);
        System.out.println(card.repr());
    }

    private static void manageCards() {
        int choice = 0;

        do {
            cardMenu();
            System.out.print("Enter your choice: ");
            choice = Utils.readInt();
            System.out.println();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    removeCard();
                    break;
                case 3:
                    updateCard();
                    break;
                case 4:
                    displayAllCards();
                    break;
                case 5:
                    findCard();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }

    // End of Card Management

    // Claim Management
    private static void manageClaims() {
    }

    // End of Claim Management
    public static void main(String[] args) {
        readCustomer();
        readCard();

        int choice = 0;

        do {
            System.out.println("1. Manage customers");
            System.out.println("2. Manage cards");
            System.out.println("3. Manage claims");
            System.out.println("0. Exit");
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
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        } while (choice != 0);

        storeCustomer();
        storeCard();
        System.out.println("Goodbye!");
    }
}
