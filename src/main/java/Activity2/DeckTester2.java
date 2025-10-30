package Activity2;
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester2 {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks1 = {"jack", "queen", "king"};
		String[] suits1 = {"blue", "red"};
		int[] values1 = {11, 12, 13};

		Deck2 deck1 = new Deck2(ranks1, suits1, values1);
		System.out.println("Deck1 initially:\n" + deck1);
		System.out.println("isEmpty: " + deck1.isEmpty());
		System.out.println("size: " + deck1.size());
		System.out.println("deal: " + deck1.deal());
		System.out.println("After one deal, size: " + deck1.size());
		System.out.println();

	}
}
