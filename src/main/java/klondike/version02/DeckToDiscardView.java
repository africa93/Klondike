package klondike.version02;

public class DeckToDiscardView {

	private DeckToDiscard deckToDiscard;

	public DeckToDiscardView(DeckToDiscard deckToDiscard) {
		this.deckToDiscard = deckToDiscard;
	}

	public void render() {

		deckToDiscard.move();
	}

}
