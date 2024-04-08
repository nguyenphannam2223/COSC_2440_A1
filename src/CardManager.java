import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class CardManager {
    private List<InsuranceCard> cards;
    private static CardManager instance;

    private CardManager() {
        this.cards = new ArrayList<>();
    }

    public static CardManager getInstance() {
        if (instance == null) {
            instance = new CardManager();
        }
        return instance;
    }

    public boolean containsCard(String cardNumber) {
        return instance.cards.stream().anyMatch(card -> card.getCardNumber().equals(cardNumber));
    }

    public void addCard(InsuranceCard card) {
        cards.add(card);

        for (Customer customer : CustomerManager.getInstance().getCustomers()) {
            if (customer.getID().equals(card.getOwnerID())) {
                customer.setCardNumber(card.getCardNumber());
            }
        }
    }

    public void removeCard(String cardNumber) {
        cards.removeIf(card -> card.getCardNumber().equals(cardNumber));
    }

    public List<InsuranceCard> getCards() {
        return cards;
    }

    public InsuranceCard getCardByNumber(String cardNumber) {
        for (InsuranceCard card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    public void sortByID() {
        cards.sort((card1, card2) -> card1.getOwnerID().compareTo(card2.getOwnerID()));
    }

    public void sortByExpirationDate() {
        cards.sort((card1, card2) -> card1.getExpirationDate().compareTo(card2.getExpirationDate()));
    }
}