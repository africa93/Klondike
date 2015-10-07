package klondike.version02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SuitTest {
	private Suit suit;
	private Card c;
	private Card c1;
	private Card c2;
	@Before
	public void init(){
		suit = new Suit(TypeOfSuit.coins);
		c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		c1 = new Card(2,TypeOfSuit.coins, true,Color.Black );
		c2 = new Card(3,TypeOfSuit.clubs, true,Color.Black );
	}
	
	@Test
	public void testAdd() {
		assertTrue(suit.add(c));
		assertTrue(suit.add(c1));
		assertFalse(suit.add(c2));
	}

	@Test
	public void testGetLastCard() {
		suit.add(c);
		suit.add(c1);
		assertEquals(suit.getLastCard(), c1);
	}

	@Test
	public void testRemoveLastCard() {
		suit.add(c);
		suit.add(c1);
		assertEquals(suit.removeLastCard(), c1);
		assertTrue(suit.getSize()==1);
	}

}
