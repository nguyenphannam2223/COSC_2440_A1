import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class CardManager {
    private List<InsuranceCard> cards;

    public CardManager() {
        this.cards = new ArrayList<>();
    }

    public void addCard(InsuranceCard card) {
        cards.add(card);
    }

    public void removeCard(String cardNumber) {
        cards.removeIf(card -> card.getCardNumber().equals(cardNumber));
    }

    public InsuranceCard getCardByNumber(String cardNumber) {
        for (InsuranceCard card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }
}
