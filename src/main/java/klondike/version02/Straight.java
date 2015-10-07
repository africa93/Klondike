package klondike.version02;

import java.util.ArrayList;

public class Straight {
	private final int initialSize;
	private ArrayList<Card> cards;
	
	public Straight(int size){
		this.initialSize = size;
		cards = new ArrayList<Card>();
	}
	
	public void add(Card card){
		if(cards.size()<initialSize){
			cards.add(card);
		}
		if (initialSize == cards.size()){
			cards.get(initialSize-1).setFaceUp(true);
		}
	}
	
	public boolean addMovedCard(Card card){
		assert card != null;
		Card lastCard = cards.get(cards.size()-1);
		if(lastCard.getFace()+1 == card.getFace() && !lastCard.getColor().equals(card.getColor())){
			return cards.add(card);
		}
		return false;
	}

	public int getNumCards() {
		return cards.size();
	}

	public Card getLastCard() {
		return cards.get(cards.size()-1);
	}

	public Card removeLastCard() {
		Card card = cards.get(cards.size()-1);
		cards.remove(cards.size()-1);
		return card;
	}

	public int getInitialSize() {
		return initialSize;
	}
}
