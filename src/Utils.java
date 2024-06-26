import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class Utils {
    private static final Scanner reader = new Scanner(System.in);

    public static final int CUSTOMER_ID_LENGTH = 7;
    public static final int CARD_NUMBER_LENGTH = 10;
    public static final int CLAIM_ID_LENGTH = 10;
    public static final String CUSTOMER_HEADER_FORMAT = "%-10s\t%-20s\t%-10s\t%-20s\t%-20s\n";
    public static final String CUSTOMER_RECORD_FORMAT = "%-10s\t%-20s\t%-10s\t%-20d\t%-20s\n";

    public static final String CARD_HEADER_FORMAT = "%-15s\t%-15s\t%-15s\t%-15s\n";
    public static final String CARD_RECORD_FORMAT = "%-15s\t%-15s\t%-15s\t%-15s";

    public static final String CLAIM_HEADER_FORMAT = "%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n";
    public static final String CLAIM_RECORD_FORMAT = "%-15s\t%-15s\t%-15s\t%-15s\t%-15.2f\t%-15s\t%-15s";

    public static final String CUSTOMER_DATA_FILE = "customers.csv";
    public static final String CLAIM_DATA_FILE = "claims.csv";
    public static final String INSURANCE_DATA_FILE = "cards.csv";

    private static boolean isValidID(String ID, int length) {
        return ID.matches("[0-9]{" + length + "}");
    }

    public static String readCustomerID(String message) {
        String customerID = "";
        do {
            System.out.print(message);
            customerID = reader.nextLine();
        } while (!isValidID(customerID, CUSTOMER_ID_LENGTH));

        return "c-" + customerID;
    }

    public static String readInsuranceCardNumber() {
        String cardNumber = "";
        do {
            System.out.print("Enter insurance card number (10 numbers): ");
            cardNumber = reader.nextLine();
        } while (!isValidID(cardNumber, CARD_NUMBER_LENGTH));

        return cardNumber;
    }

    public static String readClaimID() {
        String claimID = "";
        do {
            System.out.print("Enter claim ID (10 numbers): ");
            claimID = reader.nextLine();
        } while (!isValidID(claimID, CLAIM_ID_LENGTH));

        return "f-" + claimID;
    }

    public static int readInt(String message) {
        System.out.print(message);
        return Integer.parseInt(reader.nextLine());
    }

    public static double readDouble(String message) {
        System.out.print(message);
        return Double.parseDouble(reader.nextLine());
    }

    public static String readString(String message) {
        System.out.print(message);
        return reader.nextLine();
    }

    public static LocalDate readDate(String message) {
        int year = readInt("Enter " + message + " year: ");
        int month = readInt("Enter " + message + " month: ");
        int day = readInt("Enter " + message + " day: ");

        return LocalDate.of(year, month, day);
    }

    public static PrintWriter getFileWriter(String fileName) {
        try {
            return new PrintWriter(new FileWriter(fileName));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Scanner getFileReader(String fileName) {
        try {
            return new Scanner(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
