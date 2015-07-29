import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;




//import org.mockito.*;
import static org.mockito.Mockito.*;

public class HouseTest {

	//This tests houseCreation() method, same as getDescription()
	@Test
	public void testHouseCreation() {
		Room mockedRoom = mock(Room.class);

		Room[] rooms = new Room[1];
		rooms[0] = mockedRoom;
		stub(mockedRoom.getDescription()).toReturn("foo");
		
		House h = new House(rooms);
		String returned = h.getCurrentRoomInfo();
		assertEquals(returned, "foo");
		
	}
	//This tests getDescription() method in the getCurrentRoomInfo()
	@Test
	public void testGetCurrentRoomInfo() {
		Room r = mock(Room.class); 
		when(r.getDescription()).thenReturn("TEST"); 
		Room[] rooms = new Room[1];
		rooms[0] = r;
		House h = new House(rooms);
		String result = h.getCurrentRoomInfo();
		assertEquals(result, "TEST");

	}
	
	
	//This tests the generateRooms() method returns the correct length of array
	@Test 
	public void testGenerateRooms(){
		House h = new House(1);
		Room[] r = h.generateRooms(1);
		//Boolean result = r[0].hasItem();

		assertEquals(1, r.length);
		
		
	}
	

}
