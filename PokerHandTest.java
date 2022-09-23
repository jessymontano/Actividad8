public class PokerHandTest {
    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();
        PokerHand hand1 = new PokerHand(d), hand2 = new PokerHand(d);

        System.out.println("Cartas del jugador 1: " + hand1.cards);
        System.out.println("Cartas del jugador 2: " + hand2.cards);
        System.out.println("Mano ganadora: " + hand1.betterHand(hand2));
    }
}
