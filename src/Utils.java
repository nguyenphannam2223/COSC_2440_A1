import java.util.Scanner;

public class Utils {
    private static final Scanner reader = new Scanner(System.in);
    public static final int CUSTOMER_ID_LENGTH = 7;
    public static final int INSURANCE_CARD_NUMBER_LENGTH = 10;
    public static final int CLAIM_ID_LENGTH = 10;
    public static final String CUSTOMER_HEADER_FORMAT = "%-10s\t%-15s\t%-10s\t%-20s\n";
    public static final String CUSTOMER_RECORD_FORMAT = "%-10s\t%-15s\t%-10s\t%-20d";

    private static boolean isValidID(String ID, int length) {
        return ID.matches("[0-9]{" + length + "}");
    }

    public static String readCustomerID() {
        String customerID = "";
        do {
            System.out.print("Enter customer ID (7 numbers): ");
            customerID = reader.nextLine();
        } while (!isValidID(customerID, CUSTOMER_ID_LENGTH));

        return "c-" + customerID;
    }

    public static String readInsuranceCardNumber() {
        String cardNumber = "";
        do {
            System.out.print("Enter insurance card number (10 numbers): ");
            cardNumber = reader.nextLine();
        } while (!isValidID(cardNumber, INSURANCE_CARD_NUMBER_LENGTH));

        return cardNumber;
    }

    public static String readClaimID() {
        String claimID = "";
        do {
            System.out.print("Enter claim ID (10 numbers): ");
            claimID = reader.nextLine();
        } while (!isValidID(claimID, CLAIM_ID_LENGTH));

        return claimID;
    }

    public static int readInt() {
        return Integer.parseInt(reader.nextLine());
    }

    public static double readDouble() {
        return Double.parseDouble(reader.nextLine());
    }

    public static String readString() {
        return reader.nextLine();
    }
}
