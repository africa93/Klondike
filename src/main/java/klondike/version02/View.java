package klondike.version02;

public interface View {
	void render();

	void atender(DeckToDiscard deckToDiscard);

	void atender(DiscardToDeck discardToDeck);
	
	void atender(DiscardToSuit discardToSuit);

	void atender(DiscardToStright discardToStright);
	
	void atender(StraightToSuit straightToSuit);
	
	void atender(StraightToStraight straightToStraight);

	void atender(SuitToStraight suitToStraight);
}
