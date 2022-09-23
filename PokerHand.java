import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand{

    private static final int HIGHCARD = 0, ONEPAIR = 1, TWOPAIRS = 2, THREEOFAKIND = 3, STRAIGHT = 4, FLUSH = 5,
            FULLHOUSE = 6, FOUROFAKIND = 7, STRAIGHTFLUSH = 8, ROYALFLUSH = 9;
    public List<Card> hand;

    public PokerHand(Deck deck) {
        hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.draw());
        }
        Collections.sort(hand);
    }

    public List<Card> betterHand(PokerHand p) {
        if (this.handType() > p.handType()) {
            return hand;
        } else if (p.handType() > this.handType()) {
            return p.hand;
        } else
            return this.highCard(p);
    }

    private List<Card> highCard(PokerHand p) {
        for (int i = 4; i >= 0; i--) {
            if (this.hand.get(i).getRank() > p.hand.get(i).getRank()) {
                return this.hand;
            } else if (p.hand.get(i).getRank() > this.hand.get(i).getRank()) {
                return p.hand;
            }
        }
        return null;
    }

    private int handType() {
        if (royalFlush()) {
            return ROYALFLUSH;
        } else if (straightFlush()) {
            return STRAIGHTFLUSH;
        } else if (fourOfAKind()) {
            return FOUROFAKIND;
        } else if (fullHouse()) {
            return FULLHOUSE;
        } else if (flush()) {
            return FLUSH;
        } else if (straight()) {
            return STRAIGHT;
        } else if (threeOfAKind()) {
            return THREEOFAKIND;
        } else if (twoPairs()) {
            return TWOPAIRS;
        } else if (onePair()) {
            return ONEPAIR;
        } else {
            return HIGHCARD;
        }
    }

    private boolean numberOfMatches(int numToMatch) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (this.hand.get(i).getRank() == this.hand.get(j).getRank()) {
                    counter++;
                }
            }
        }
        return counter == numToMatch;
    }

    private boolean onePair() {
        return numberOfMatches(1);
    }

    private boolean twoPairs() {
        return numberOfMatches(2);
    }

    private boolean threeOfAKind() {
        return numberOfMatches(3);
    }

    private boolean straight() {
        for (int i = 1; i < 5; i++) {
            if (this.hand.get(i).getRank() != this.hand.get(i-1).getRank() + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean flush() {
        for (int i = 1; i < 5; i++) {
            if (hand.get(0).getSuit() != hand.get(i).getSuit()) {
                return false;
            }
        }
        return true;
    }

    private boolean fullHouse() {
        return numberOfMatches(4);
    }

    private boolean fourOfAKind() {
        return numberOfMatches(6);
    }

    private boolean straightFlush() {
        return flush() && straight();
    }

    private boolean royalFlush() {
        return flush() && this.hand.get(0).getRank() == 1 && this.hand.get(1).getRank() == 10 && this.hand.get(2).getRank() == 11
                && this.hand.get(3).getRank() == 12 && this.hand.get(4).getRank() == 13;
    }

}


