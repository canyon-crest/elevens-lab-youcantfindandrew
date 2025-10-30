package Activity1;
/**
 * This is a class that tests the Card class.
 */
public class CardTester1 {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card1 card1 = new Card1("Ace", "Hearts", 1);
		Card1 card2 = new Card1("Ace", "Hearts", 1);
		Card1 card3 = new Card1("King", "Spades",10);

		// Test accessor methods
		System.out.println("Card1: rank=" + card1.rank() + ", suit=" + card1.suit() + ", pointValue=" + card1.pointValue());
		System.out.println("Card2: rank=" + card2.rank() + ", suit=" + card2.suit() + ", pointValue=" + card2.pointValue());
		System.out.println("Card3: rank=" + card3.rank() + ", suit=" + card3.suit() + ", pointValue=" + card3.pointValue());

		// Test matches method
		System.out.println("card1 matches card2: " + card1.matches(card2));
		System.out.println("card1 matches card3: " + card1.matches(card3));

		// Test toString method
		System.out.println("card1 toString: " + card1.toString());
		System.out.println("card2 toString: " + card2.toString());
		System.out.println("card3 toString: " + card3.toString());
	}
}
