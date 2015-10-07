package klondike.version02;

import java.util.ArrayList;

public class Board implements BoardForView{
	public ArrayList<Card> deck;
	public ArrayList<Card> discard;
	public Straight[] straights;
	public Suit[] suits;
	public static final int NUM_SUITS = 4;
	public static final int NUM_STRAIGHTS=7;

	public Board(){
		deck = new ArrayList<Card>();
		ArrayList <Card> cards = new ArrayList<Card>();
		DeckOfCards deckOfCards =new DeckOfCards();
		cards = deckOfCards.suffle();

		for(int i=0; i<20; i++){
			deck.add(cards.get(i));
		}

		discard = new ArrayList<Card>();

		straights = new Straight [NUM_STRAIGHTS];

		int contador = 20;
		for (int i=0; i<NUM_STRAIGHTS; i++){
			straights[i] = new Straight(i+1);
			for(int j=0; j<straights[i].getInitialSize();j++){
				straights[i].add(cards.get(contador));
				contador++;
			}
		}
		suits = new Suit[NUM_SUITS];
		suits[0] = new Suit(TypeOfSuit.coins);
		suits[1] = new Suit(TypeOfSuit.cups);
		suits[2] = new Suit(TypeOfSuit.spades);
		suits[3] = new Suit(TypeOfSuit.clubs);

	}

	@Override
	public Color getColor(Card card) {
		assert card != null;
		return card.getColor();

	}

	public boolean isFinished() {
		if(suits[0].getSize()==12 && suits[1].getSize()==12 && suits[2].getSize()== 12&&suits[3].getSize()==12){
			return true;
		}
		return false;
	}

	public Straight getStraight(int numStraight){
		return straights[numStraight];
	}

	public Card getLastDiscard(){
		if(discard.size()==0){
			return null;
		}
		return discard.get(discard.size()-1);
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Card> getDiscard(){
		return discard;
	}

	public Suit getSuit(int numSuit){
		return suits[numSuit];
	}

	public void moveToDiscard() {
		int index = 0;
		while(index<3 && deck.size()>0){
			discard.add(deck.get(0));
			deck.remove(0);
			index++;
		}
	}

	public void moveToDeck() {
		while(discard.size()>0){
			deck.add(discard.get(0));
			discard.remove(0);
		}
	}

	public boolean moveToSuit(){
		Card dicardCard = getLastDiscard();
		if(dicardCard == null){
			return false;
		}
		for(int i =0; i<suits.length-1; i++){
			if(suits[i].getName().equals(dicardCard.getSuit())){
				Card suitCard = suits[i].getLastCard();
				if(suitCard == null && dicardCard.getFace()==1){
					suits[i].add(dicardCard);
					discard.remove(dicardCard);
					return true;
				}
				if(suitCard.getFace()+1==dicardCard.getFace()){
					suits[i].add(dicardCard);
					discard.remove(dicardCard);
					return true;
				}
			}
		}
		return false;
	}

	public boolean moveStraightToStraight(int oldStraight, int newStraight) {
		Card card = straights[oldStraight].getLastCard();
		System.out.println(card.getFace());
		boolean result = straights[newStraight].addMovedCard(card);
		if(result){
			straights[oldStraight].removeLastCard();
		}
		return result;
	}

	public boolean straightToSuit(int straight) {
		boolean result=true;
		Card card = straights[straight].getLastCard();
		System.out.println(card.getFace());
		for(int i=0; i<=suits.length-1;i++){
			if(suits[i].getName().equals(straights[straight].getLastCard().getSuit())){
				result = suits[i].add(straights[straight].removeLastCard());
			}
		}
		if(!result){
			straights[straight].addMovedCard(card);
		}
		return result;
	}

	public boolean moveSuitToStraight(int suit, int straight) {
		Card card = suits[suit].removeLastCard();
		boolean result = straights[straight].addMovedCard(card);
		if(!result){
			straights[straight].addMovedCard(card);
		}
		return result;
	}
	
	public Board(ArrayList<Card> deck,ArrayList<Card> discard,Straight[] straights,Suit[] suits){
		this.deck = deck;
		this.discard = discard;
		this.straights = new Straight[NUM_STRAIGHTS];
		this.straights = straights;
		this.suits = new Suit[NUM_SUITS];
		this.suits = suits;
	}
}
