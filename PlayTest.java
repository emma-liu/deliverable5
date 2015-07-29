import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayerTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	@Test
	public void testGetSugar() {
		Player p = new Player();
		p.getSugar();
		assertEquals("You found some sweet sugar!\n", outContent.toString());
	}
	@Test
	public void testGetCream() {
		Player p = new Player();
		p.getCream();
		assertEquals("You found some creamy cream!\n", outContent.toString());
	}
	@Test
	public void testGetCoffee() {
		Player p = new Player();
		p.getCoffee();
		assertEquals("You found some caffeinated coffee!\n", outContent.toString());
	}
	@Test
	public void testHasAllItems(){
		Player p = new Player();
		//before get any item
		Boolean result = p.hasAllItems();
		assertEquals(result, false);
		//get coffee
		p.getCoffee();
		Boolean result1 = p.hasAllItems();
		assertEquals(result1, false);
		//get cream, has cream and coffee
		p.getCream();
		Boolean result2 = p.hasAllItems();
		assertEquals(result2, false);
		//get sugar, has cream sugar and coffee
		p.getSugar();
		Boolean result3 = p.hasAllItems();
		assertEquals(result3, true);
	}
	@Test
	public void testShowInventory_HasCoffee() throws IOException{
		Player p = new Player();
		//without any item
		p.showInventory();
		assertEquals("YOU HAVE NO COFFEE!\n" + "YOU HAVE NO CREAM!\n" + "YOU HAVE NO SUGAR!\n", outContent.toString());
		//assert has coffee
		p.getCoffee();
		outContent.reset();
		p.showInventory();
		assertEquals("You have a cup of delicious coffee.\n" + "YOU HAVE NO CREAM!\n" + "YOU HAVE NO SUGAR!\n", outContent.toString());
		//assert has coffee and cream
		p.getCream();
		outContent.reset();
		p.showInventory();
		assertEquals("You have a cup of delicious coffee.\n" + "You have some fresh cream.\n" + "YOU HAVE NO SUGAR!\n", outContent.toString());
		//assert has coffee, cream and sugar
		p.getSugar();
		outContent.reset();
		p.showInventory();
		assertEquals("You have a cup of delicious coffee.\n" + "You have some fresh cream.\n" + "You have some tasty sugar.\n", outContent.toString());
	}
	@Test
	public void testDrink(){
		//drink without any item
		Player p = new Player();
		p.drink();
		assertEquals("YOU HAVE NO COFFEE!\n" + "YOU HAVE NO CREAM!\n" + "YOU HAVE NO SUGAR!\n" + "\n" + "You drink the air, as you have no coffee, sugar, or cream.\n"
				+ "The air is invigorating, but not invigorating enough.  You cannot study.\n", outContent.toString());
		//drink with coffee only
		p.getCoffee();
		outContent.reset();
		p.drink();
		assertEquals("You have a cup of delicious coffee.\n" + "YOU HAVE NO CREAM!\n" + "YOU HAVE NO SUGAR!\n" + "\n"
				+ "Without cream, you get an ulcer and cannot study.\n", outContent.toString());
		//drink with coffee and cream only
		Player p1 = new Player();
		p1.getCoffee();
		p1.getCream();
		outContent.reset();
		p1.drink();
		assertEquals("You have a cup of delicious coffee.\n" + "You have some fresh cream.\n" + "YOU HAVE NO SUGAR!\n" + "\n"
				+ "Without sugar, the coffee is too bitter.  You cannot study.\n", outContent.toString());
		//drink with sugar and cream only
		Player p2 = new Player();
		p2.getCream();
		p2.getSugar();
		outContent.reset();
		p2.drink();
		assertEquals("YOU HAVE NO COFFEE!\n" + "You have some fresh cream.\n" + "You have some tasty sugar.\n" + "\n"
				+ "You drink the sweetened cream, but without caffeine, you cannot study.\n", outContent.toString());
		//drink with cream only
		Player p3 = new Player();
		p3.getCream();
		outContent.reset();
		p3.drink();
		assertEquals("YOU HAVE NO COFFEE!\n" + "You have some fresh cream.\n" + "YOU HAVE NO SUGAR!\n" + "\n"
				+ "You drink the cream, but without caffeine, you cannot study.\n", outContent.toString());
		//drink with sugar only
		Player p4 = new Player();
		p4.getSugar();
		outContent.reset();
		p4.drink();
		assertEquals("YOU HAVE NO COFFEE!\n" + "YOU HAVE NO CREAM!\n" + "You have some tasty sugar.\n" + "\n"
				+ "You eat the sugar, but without caffeine, you cannot study.\n", outContent.toString());
		//drink with coffee sugar and cream
		Player p5 = new Player();
		p5.getSugar();
		p5.getCoffee();
		p5.getCream();
		outContent.reset();
		p5.drink();
		assertEquals("You have a cup of delicious coffee.\n" + "You have some fresh cream.\n" + "You have some tasty sugar.\n" + "\n"
				+ "You drink the beverage and are ready to study!\n", outContent.toString());
		
		
	}

}

