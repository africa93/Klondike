package klondike.version02;

public class Card {
	public int face;
	public TypeOfSuit suit;
	private boolean faceUp;
	private Color color;

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	public Card(int face, TypeOfSuit suit, boolean faceUp, Color color) {
		super();
		this.face = face;
		this.suit = suit;
		this.faceUp = faceUp;
		this.color = color;
	}

	public int getFace() {
		return face;
	}

	public TypeOfSuit getSuit() {
		return suit;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public Color getColor() {
		return color;
	}


}
