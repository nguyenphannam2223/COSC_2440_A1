import java.util.Date;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class Claim {
    private String claimID;
    private Date claimDate;
    private String cardNumber;
    private Date examDate;
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

    public Claim(String claimID, Date claimDate, String cardNumber, Date examDate, List<String> documents,
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

    public Date getClaimDate() {
        return claimDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExamDate() {
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

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExamDate(Date examDate) {
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
}
