import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    LinkedList<Card> cards = null;

    public Deck() {
        cards = new LinkedList<>();
        for (int i = Card.SPADES; i <= Card.CLUBS; i++) {
            for (int j = Card.ACE; j <= Card.KING; j++) {
                Card c = new Card(j, i);
                cards.add(c);
            }
        }
        // shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        Card topCard = null;

        if ( !cards.isEmpty() )
            topCard = cards.removeLast();

        return topCard;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

}