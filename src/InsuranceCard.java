import java.util.Date;

import javax.rmi.CORBA.Util;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class InsuranceCard {
    private String cardNumber;
    private String holderID;
    private String ownerID;
    private Date exprirationDate;

    public InsuranceCard(String cardNumber, String holderID, String ownerID, Date exprirationDate) {
        this.cardNumber = cardNumber;
        this.holderID = holderID;
        this.ownerID = ownerID;
        this.exprirationDate = exprirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getHolderID() {
        return holderID;
    }

    public void setHolderID(String holderID) {
        this.holderID = holderID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public Date getExprirationDate() {
        return exprirationDate;
    }

    public void setExprirationDate(Date exprirationDate) {
        this.exprirationDate = exprirationDate;
    }

    public String repr() {
        return "Insurance Card Number: " + cardNumber + "\n" +
                "Holder ID: " + holderID + "\n" +
                "Owner ID: " + ownerID + "\n" +
                "Expiration Date: " + exprirationDate + "\n";
    }

    @Override
    public String toString() {
        return String.format(Utils.CARD_RECORD_FORMAT, cardNumber, holderID, ownerID, exprirationDate);
    }
}