package klondike.version02;

import java.util.ArrayList;

public class DeckOfCards {
	private static ArrayList<Card> cards;

	public DeckOfCards(){
		cards = new ArrayList<Card>(48);
		for(int i=0; i<12; i++){
			cards.add(new Card(i+1, TypeOfSuit.coins, false, Color.Black));
		}
		for(int i=0; i<12; i++){
			cards.add(new Card(i+1, TypeOfSuit.cups, false, Color.Red));
		}
		for(int i=0; i<12; i++){
			cards.add(new Card(i+1, TypeOfSuit.spades, false, Color.Black));
		}
		for(int i=0; i<12; i++){
			cards.add(new Card(i+1, TypeOfSuit.clubs, false, Color.Red));
		}
	}

	public ArrayList<Card> suffle(){
		ArrayList<Card> suffledCards = new ArrayList<Card>(48);
		ArrayList<Card> orderedCards = new ArrayList<Card>(48);
		for(int i=0; i<cards.size(); i++){
			orderedCards.add(cards.get(i));
		}
		for(int i=0; i<cards.size(); i++){
			int index = (int)((Math.random()*1000) % orderedCards.size());
			suffledCards.add(orderedCards.get(index));
			orderedCards.remove(index);
		}
		return suffledCards;
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}
