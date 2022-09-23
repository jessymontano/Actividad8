

public class Card implements Comparable {

    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;


    private final String[] suits = new String[]{
            "spades", "hearts", "diamonds", "clubs"};

    private final String[] ranks = new String[]{
            "ace", "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "jack", "queen", "king"};


    private int rank; // valor de la carta
    private int suit; // figura de la carta

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    /*
    Dos cartas son iguales si tienen la misma figura y valor
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Card))
            return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    /* Regresa
        entero negativo, si el valor de la carta es menor que el valor de la carta c
        cero, si el valor de la carta es igual que el valor de la carta c
    entero positivo, si el valor de la carta es mayor que el valor de la carta c
     */

    @Override
    public int compareTo(Object c) {
        Card card = (Card) c;

        return  this.getRank() - card.getRank();
    }
    /*
    Genera una carta aleatoriamente
     */
    public static Card getCard() {
        Card newCard = null;

        // int valorEntero = Math.floor(Math.random()*(MAX-MIN+1)+MIN);
        int randomSuit = (int) Math.floor (Math.random() * ( CLUBS - SPADES + 1 ) + SPADES);
        int randomRank = (int) Math.floor (Math.random() * ( KING - ACE + 1 ) + ACE);


        newCard = new Card(randomRank,randomSuit);

        return newCard;
    }

    @Override
    public String toString() {
        return "Card{" + "rank=" + ranks[ rank-1 ]  + ", suit=" + suits[ suit ] + "}";
    }
}