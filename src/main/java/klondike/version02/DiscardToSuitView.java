package klondike.version02;

public class DiscardToSuitView {
	
	private DiscardToSuit discardToSuit;
	
	public DiscardToSuitView(DiscardToSuit discardToSuit) {
		this.discardToSuit = discardToSuit;
	}
	public void render() {
		discardToSuit.move();
	}
}
