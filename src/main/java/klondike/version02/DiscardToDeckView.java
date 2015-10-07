package klondike.version02;

public class DiscardToDeckView {

	private DiscardToDeck discardToDeck;
	
	public DiscardToDeckView(DiscardToDeck discardToDeck) {
		this.discardToDeck = discardToDeck;
	}

	public void render() {
		if(discardToDeck.board.getDeck().size()==0){
			discardToDeck.move();
		}
	}

}
