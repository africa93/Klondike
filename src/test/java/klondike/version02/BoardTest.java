package klondike.version02;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;
	private Suit[] suits;
	private Straight[] straights;
	private ArrayList<Card> deck;
	ArrayList<Card> discard;
	
	@Before
	public void init(){
		board = new Board();
		suits = new Suit[4];
		suits[0] = new Suit(TypeOfSuit.coins);
		suits[1] = new Suit(TypeOfSuit.cups);
		suits[2] = new Suit(TypeOfSuit.spades);
		suits[3] = new Suit(TypeOfSuit.clubs);
		straights = new Straight[7];
		discard = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		
	}

	@Test
	public void testIsFinished() {
		DeckOfCards d = new DeckOfCards();
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int i=0; i<d.getCards().size(); i++){
			cards.add(d.getCards().get(i));
		}
		for(int i=0; i<4; i++){
			for(int j=0; j<12; j++){
				suits[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		Board b = new Board(deck, discard,straights,suits);
		assertTrue(b.isFinished());
	}

	@Test
	public void testGetStraight() {
		Straight s = new Straight(1);
		straights[0] = s;
		Board b = new Board(deck, discard,straights,suits);
		assertEquals(b.getStraight(0),s);
	}

	@Test
	public void testGetLastDiscard() {
		Card c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		discard.add(c);
		Card c1 = new Card(2,TypeOfSuit.coins, true,Color.Black );
		discard.add(c1);
		Board b = new Board(deck, discard,straights,suits);
		assertEquals(b.getLastDiscard(), c1);
	}

	@Test
	public void testGetDeck() {
		Board b = new Board(deck, discard,straights,suits);
		assertEquals(b.getDeck(), deck);
	}

	@Test
	public void testGetDiscard() {
		Board b = new Board(deck, discard,straights,suits);
		assertEquals(b.getDeck(), deck);
	}

	@Test
	public void testGetSuit() {
		Suit s = new Suit(TypeOfSuit.coins);
		suits[0] = s;
		Board b = new Board(deck, discard,straights,suits);
		assertEquals(b.getSuit(0), s);
	}

	@Test
	public void testMoveToDiscard() {
		Card c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		Card c1 = new Card(2,TypeOfSuit.coins, true,Color.Black );
		Card c2 = new Card(3,TypeOfSuit.coins, true,Color.Black );
		Card c3 = new Card(4,TypeOfSuit.coins, true,Color.Black );
		Card c4 = new Card(5,TypeOfSuit.coins, true,Color.Black );
		deck.add(c);
		deck.add(c1);
		deck.add(c2);
		deck.add(c3);
		deck.add(c4);
		Board b = new Board(deck, discard,straights,suits);
		b.moveToDiscard();
		assertTrue(discard.size()==3);
	}

	@Test
	public void testMoveToDeck() {
		Card c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		Card c1 = new Card(2,TypeOfSuit.coins, true,Color.Black );
		Card c2 = new Card(3,TypeOfSuit.coins, true,Color.Black );
		Card c3 = new Card(4,TypeOfSuit.coins, true,Color.Black );
		Card c4 = new Card(5,TypeOfSuit.coins, true,Color.Black );
		discard.add(c);
		discard.add(c1);
		discard.add(c2);
		discard.add(c3);
		discard.add(c4);
		Board b = new Board(deck, discard,straights,suits);
		b.moveToDeck();
		assertTrue(deck.size()==5);
		assertTrue(discard.size()==0);
	}

	@Test
	public void testMoveToSuit() {
		Card c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		discard.add(c);
		Board b = new Board(deck, discard,straights,suits);
		assertTrue(b.moveToSuit());
		assertTrue(b.getSuit(0).getSize()==1);
		
	}

	@Test
	public void testMoveStraightToStraight() {
		Straight s = new Straight(2);
		Card c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		Card c1 = new Card(2,TypeOfSuit.coins, true,Color.Black );
		s.add(c);
		s.add(c1);
		Straight s1 = new Straight(3);
		Card c2 = new Card(4,TypeOfSuit.coins, true,Color.Black );
		Card c3 = new Card(3,TypeOfSuit.cups, true,Color.Red);
		s1.add(c);
		s1.add(c2);
		s1.add(c3);
		straights[1] = s;
		straights[2] = s1;
		Board b = new Board(deck, discard,straights,suits);
		assertTrue(b.moveStraightToStraight(2, 1));
		assertTrue(s.getNumCards()==3);
		assertTrue(s1.getNumCards()==2);
	}

}
