import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class RoomTest {
	@Test
	public void testHasItem() {
		//has coffee, sugar cream northExit and southExit
		Room r = new Room(true, true, true, true, true);
		Boolean result = r.hasItem();
		assertEquals(result, true);
		//has coffee, cream northExit and southExit
		Room r1 = new Room(true, true, false, true, true);
		Boolean result1 = r1.hasItem();
		assertTrue(result1);
		//has cream northExit and southExit
		Room r2 = new Room(false, true, false, true, true);
		Boolean result2 = r2.hasItem();
		assertTrue(result2);
		//has coffee, northExit and southExit
		Room r3 = new Room(true, false, false, true, true);
		Boolean result3 = r3.hasItem();
		assertTrue(result3);
		//has northExit and southExit
		Room r4 = new Room(false, false, false, true, true);
		Boolean result4 = r4.hasItem();
		assertFalse(result4);
	}
	@Test
	public void testHasSugar(){
		//has sugar
		Room r = new Room(true, true, true, true, true);
		Boolean result = r.hasSugar();
		assertTrue(result);
		//Does not have sugar
		Room r1 = new Room(true, true, false, true, true);
		Boolean result1 = r1.hasSugar();
		assertFalse(result1);
	}
	@Test
	public void testHasCoffee(){
		//has coffee
		Room r = new Room(true, true, true, true, true);
		Boolean result = r.hasCoffee();
		assertTrue(result);
		//Does not have  coffee
		Room r1 = new Room(false, true, true, true, true);
		Boolean result1 = r1.hasCoffee();
		assertFalse(result1);
	}
	@Test
	public void testHasCream(){
		//has cream
		Room r = new Room(true, true, true, true, true);
		Boolean result = r.hasCream();
		assertTrue(result);
		//Does not have  cream
		Room r1 = new Room(true, false, true, true, true);
		Boolean result1 = r1.hasCream();
		assertFalse(result1);
	}
	@Test
	public void testNorthExit(){
		//has north Exit
		Room r = new Room(true, true, true, true, true);
		Boolean result = r.northExit();
		assertTrue(result);
		//Does not have north Exit
		Room r1 = new Room(true, true, true, false, true);
		Boolean result1 = r1.northExit();
		assertFalse(result1);
	}
	@Test
	public void testSouthExit(){
		//has south Exit
		Room r = new Room(true, true, true, true, true);
		Boolean result = r.southExit();
		assertTrue(result);
		//Does not have south Exit
		Room r1 = new Room(true, true, true, true, false);
		Boolean result1 = r1.southExit();
		assertFalse(result1);
	}
	
	@Test
	public void testGetDescription(){
		//assert getDescription() is called and the returned type is string
		Room r = new Room(true, true, true, true, true);
		assertThat(r.getDescription(), instanceOf(String.class));
	}
	@Test
	public void testGenerateDescription(){
		Room r1 = new Room(true, true, true, true, true);
		//call generateDescription() through getDescription()
		String s1 = r1.getDescription();
		//assert the "north exit" branch is called
		assertTrue(s1.contains("North")); 
		Room r2 = new Room(true, true, true, true, true);
		String s2 = r2.getDescription();
		//assert the "south exit" branch is called
		assertTrue(s2.contains("South")); 
	}
	
	@Test
	public void testGetNoun(){
		Room r1 = new Room(true, true, true, true, true);
		String[] nouns = { "kettle", "sink", "sofa", "plant", "elephant", "bird cage", "record player", "picture of a ghost",
		         "picture of a dog", "dresser", "book", "pizza", "cake", "pinball game",
		         "slug", "board game", "energy drink", "jack o' lantern", "fireplace",
		         "pumpkin spice latte", "copy machine", "bag of money", "stapler",
		         "bottle", "xylophone", "tablecloth", "air hockey table", "textbook", "dog", "duck", "programmer",
		         "radish", "clock", "carpet", "rug", "stamp collection"};
		String s1 = r1.getDescription();
		boolean isFromNounArray = false;
		
		//loop string array whether it contains a called noun in order to assert getNoun() is called
		for(int i = 0; i < nouns.length; i++){
			if(s1.contains(nouns[i])){
				isFromNounArray = true;
				break;
			}
		}
		assertTrue(isFromNounArray);
	}
	
	@Test
	public void testGetAdjective(){
		Room r1 = new Room(true, true, true, true, true);
		String[] adjs = { "Small",  "Quaint", 
		        "Shiny", "Magenta", "Funny", "Sad", "Fuchsia", "Beige", "Massive", "Refinanced", "Tight", "Loose",
		        "Dead", "Smart", "Dumb", "Flat", "Bumpy", "Vivacious", 
		        "Slim", "Bloodthirsty", "Beautiful", 
		        "Flowery", "Purple", "Sandy", "Rough",
		        "Perfect", "Heroic", "Minimalist", "Shoe-Losing", "Major", 
		        "Wonderful", "Loving", "Fun-Loving",
		        "High-Level", "Functional","Static", "Dynamic",
		        "Fast", "Bulletproof", "Late", "Silly",
		        "Salty", "Sour", 
		        "Chair-Adjusting", "Brave", "Forgetful", "Chair-Sitting", "Mind-Blowing", "Crazy",
		        "Funny", "Birdlike", "Bird-Brained", "Miniature", 
		        "High-Strung", "Famous", "Light", "Dark", "Feral", "Hairy",
		        "Leaky", "Criminal", "Sassy", "Frumpy", "Tiny", 
		        "Prehistoric", "Metallic", "Sharp", "Historical", "Fierce", "Loud",
		        "Lunar", "Bohemian", "Bored", "Suspicious", 
		        "Flirtatious", "Street-Smart", "Forgetful",  
		        "Tooth-Filled", "Ravenous", 
		        "Well-Directed", "Well-Fed", "Well-Maintained", "Deep", "Shallow",
		        "Victorian", "Formal", "Creamy", "Tangy", "Fresh", "Magical", "Mystical",
		        "Secret", "Prophetic", "Immortal", "Far-Sighted",
		        "Short-Sighted",  "Latin", "Nepalese",  "Medical",
		        "Straightforward", "Literary", "Critical", "Backward", "Rabid", "Bombastic",
		        "Smelly", "Wanton", "Confusing", "Cheesy",
		        "Devious", "Pumpkin Spice", "Submerged", "Muscular",
		        "Well-Organized", "Smooth", "Delicious", "Creamy", "Dry", 
		        "Independent", "Free", "Cheap", "Diaphonous", "Tired",
		        "Sultry", "Beguiling", "Long-Lived", "Repetitive",
		        "Disgusting", "Swampy", "Dirty", "Muddy", "Clean", "Dry", "Wet",
		        "Clear", "Transparent", "Glorious", "Sacrificial", "Electric", "Mechanical",
		        "Automatic", "Rapid", "Nervous", "Calm", "Contemplative",
		        "Cerebral", "Voracious", "Starving", "Full", "Killer", "Wicked", "Rational", "Real",
		        "Homemade", "Cigar-Chomping", "Sinister", "Doubting",
		        "Robotic", "Monosyllabic", "Maniacal", "Postmodern", "Prehistoric" };
		String s1 = r1.getDescription();
		boolean isFromNounArray = false;
		//loop string array whether it contains a called adjective in order to assert getAdjective() is called
		for(int i = 0; i < adjs.length; i++){
			if(s1.contains(adjs[i])){
				isFromNounArray = true;
				break;
			}
		}
		assertTrue(isFromNounArray);
	}
}

//Room r = mock(Room.class);
//when(r.getDescription()).thenReturn("TEST");
//Room[] rooms = new Room[1];
//rooms[0] = r;
//House h = new House(rooms);
//String result = h.getCurrentRoomInfo();
//assertEquals(result, "TEST");
