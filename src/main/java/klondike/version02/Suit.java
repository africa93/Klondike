package klondike.version02;

import java.util.ArrayList;

public class Suit {
	private TypeOfSuit suit;
	private ArrayList<Card> cards;
	
	public Suit(TypeOfSuit suit){
		this.suit = suit;
		cards = new ArrayList<Card>();
	}
	
	public boolean add(Card card){
		assert card.getSuit().toString().equals(suit.toString());
		if(cards.size() == 0 && card.getFace()==1 && card.getSuit().toString().equals(suit.toString())){
			card.setFaceUp(true);
			cards.add(card);
			return true;
		}
		if(cards.get(cards.size()-1).getFace()+1 == card.getFace()&& card.getSuit().toString().equals(suit.toString())){
			card.setFaceUp(true);
			cards.add(card);
			return true;
		}
		return false;
	}

	public int getSize() {
		return cards.size();
	}

	public TypeOfSuit getName(){
		return suit;
	}

	public Card getLastCard() {
		if(cards.size()==0){
			return null;
		}
		return cards.get(cards.size()-1);
	}
	public Card removeLastCard(){
		Card card = getLastCard();
		if(cards.size()>0){
			cards.remove(cards.size()-1);
		}
		return card;
	}
}
