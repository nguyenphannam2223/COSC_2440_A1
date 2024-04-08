import java.time.LocalDate;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class Claim {
    private String claimID;
    private LocalDate claimDate;
    private String cardNumber;
    private LocalDate examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBankInfo;

    public Claim(String claimID, String cardNumber, double claimAmount, String status, String receiverBankInfo) {
        this.claimID = claimID;
        this.cardNumber = cardNumber;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankInfo = receiverBankInfo;
    }

    public Claim(String claimID, LocalDate claimDate, String cardNumber, LocalDate examDate, List<String> documents,
            double claimAmount, String status, String receiverBankInfo) {
        this.claimID = claimID;
        this.claimDate = claimDate;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankInfo = receiverBankInfo;
    }

    public String getClaimID() {
        return claimID;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getReceiverBankInfo() {
        return receiverBankInfo;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReceiverBankInfo(String receiverBankInfo) {
        this.receiverBankInfo = receiverBankInfo;
    }

    public void adapt(Claim claim) {
        this.claimID = claim.getClaimID();
        this.claimDate = claim.getClaimDate();
        this.cardNumber = claim.getCardNumber();
        this.examDate = claim.getExamDate();
        this.documents = claim.getDocuments();
        this.claimAmount = claim.getClaimAmount();
        this.status = claim.getStatus();
        this.receiverBankInfo = claim.getReceiverBankInfo();
    }

    @Override
    public String toString() {  
        return String.format(Utils.CLAIM_RECORD_FORMAT, claimID, claimDate, cardNumber, examDate, claimAmount, status,
                receiverBankInfo);
    }

    public String repr() {
        return "Claim ID: " + claimID + "\n" +
                "Claim Date: " + claimDate + "\n" +
                "Card Number: " + cardNumber + "\n" +
                "Exam Date: " + examDate + "\n" +
                "Documents: " + documents + "\n" +
                "Claim Amount: " + claimAmount + "\n" +
                "Status: " + status + "\n" +
                "Receiver Bank Info: " + receiverBankInfo + "\n";
    }
}
