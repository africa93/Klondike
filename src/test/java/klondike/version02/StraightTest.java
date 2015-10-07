package klondike.version02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StraightTest {
	private Straight straight;
	private Card c;
	private Card c1;
	private Card c2;
	@Before
	public void init(){
		straight = new Straight(2);
		c = new Card(1,TypeOfSuit.coins, true,Color.Black );
		c1 = new Card(2,TypeOfSuit.coins, true,Color.Black );
		c2 = new Card(3,TypeOfSuit.coins, true,Color.Black );
	}
	
	@Test
	public void testAdd() {
		straight.add(c);
		straight.add(c2);
		assertTrue(straight.getNumCards()==2);
		straight.add(c2);
		assertTrue(straight.getNumCards()==2);
	}

	@Test
	public void testAddMovedCard() {
		straight.add(c);
		straight.add(c1);
		assertFalse(straight.addMovedCard(c2));
		Card c3 = new Card(3,TypeOfSuit.cups, true,Color.Red);
		assertTrue(straight.addMovedCard(c3));
		assertTrue(straight.getNumCards()==3);
		Card c4 = new Card(4,TypeOfSuit.coins, true,Color.Black);
		assertTrue(straight.addMovedCard(c4));
	}

	@Test
	public void testGetLastCard() {
		straight.add(c);
		straight.add(c1);
		assertEquals(straight.getLastCard(), c1);
	}

	@Test
	public void testRemoveLastCard() {
		straight.add(c);
		straight.add(c1);
		assertEquals(straight.removeLastCard(), c1);
	}

}
