package Activity10;
import java.util.List;
import java.util.ArrayList;

/**
 * The ThirteensBoard class represents the board in a game of Thirteens.
 */
public class ThirteensBoard10 extends Board10 {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

	/**
	 * Creates a new <code>ThirteensBoard</code> instance.
	 */
	 public ThirteensBoard10() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 13, and (2) a king.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards == null) {
			return false;
		}
		if (selectedCards.size() == 1) {
			return containsKing(selectedCards);
		}
		if (selectedCards.size() == 2) {
			return containsPairSum13(selectedCards);
		}
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 13, or (2) a king.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		return containsPairSum13(cIndexes) || containsKing(cIndexes);
	}

	/**
	 * Look for an 13-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 13-pair.
	 * @return true if the board entries in selectedCards
	 *              contain a 13-pair; false otherwise.
	 */
	private boolean containsPairSum13(List<Integer> selectedCards) {
		if (selectedCards == null || selectedCards.size() < 2) {
			return false;
		}
		for (int i = 0; i < selectedCards.size(); i++) {
			int k1 = selectedCards.get(i).intValue();
			Card10 c1 = cardAt(k1);
			if (c1 == null) {
				continue;
			}
			for (int j = i + 1; j < selectedCards.size(); j++) {
				int k2 = selectedCards.get(j).intValue();
				Card10 c2 = cardAt(k2);
				if (c2 == null) {
					continue;
				}
				if (c1.pointValue() + c2.pointValue() == 13) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Look for a king in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a king.
	 * @return true if the board entries in selectedCards include a king; false otherwise.
	 */
	private boolean containsKing(List<Integer> selectedCards) {
		if (selectedCards == null || selectedCards.isEmpty()) {
			return false;
		}
		for (int i = 0; i < selectedCards.size(); i++) {
			int k = selectedCards.get(i).intValue();
			Card10 c = cardAt(k);
			if (c != null && "king".equals(c.rank())) {
				return true;
			}
		}
		return false;
	}
}


