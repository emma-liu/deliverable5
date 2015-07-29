public class House {

	private int _numRooms = 6;
	
	private Room[] _rooms = new Room[_numRooms];
	
	private int _currentRoom = 0;
	
	//make sure that there is at least one room
	public House(int numRooms) {
		if (numRooms>0) 
		{
			_numRooms = numRooms;
		}
		_rooms = generateRooms(_numRooms);
	}
	
	public House(Room[] rooms) {
		_numRooms = rooms.length;
		_rooms = rooms;
	}
	
	//remove the magical land 
	public String getCurrentRoomInfo() {
		System.out.println("\nRoom: "+ (_currentRoom+1));
		return _rooms[_currentRoom].getDescription();
		
	}
	
	//add a room number method to show which room you are in
	
	public int getCurrentRoomNumber() {
		return _currentRoom;
	}
	
	public void moveNorth() {
		if(_rooms[_currentRoom].northExit()){
			_currentRoom += 1;
			}else{ 
				System.out.println("There is no door from the north. Please try another instruction");
				
			}
	}
	
	public void moveSouth() {
		if(_rooms[_currentRoom].northExit()){
			_currentRoom -= 1;
			}else{ 
				System.out.println("There is no door from the south. Please try another instruction");
			}
				
	}
	
	public void look(Player player) {
		
		Room room = _rooms[_currentRoom];
		
		if (room.hasItem()) {
			System.out.println("There might be something here...");
			if (room.hasCoffee()) {
				player.getCoffee();
			}
			if (room.hasCream()) {
				player.getCream();
			}
			if (room.hasSugar()) {
				player.getSugar();
			}
		} else {
			System.out.println("You don't see anything out of the ordinary.");
		}
	}
	
	public Room[] generateRooms(int numRooms) {
		
		Room[] toReturn = new Room[numRooms];
		
		boolean northDoor = true;
		boolean southDoor = true;
		boolean hasCoffee = false;
		boolean hasCream = false;
		boolean hasSugar = false;
		
		for (int j = 0; j < numRooms; j++) {
			
			if (j == 0) { hasCream = true; } else {hasCream = false; };
			if (j == 2) { hasCoffee = true; } else {hasCoffee = false; };
			if (j == (numRooms - 1)) { hasSugar = true; } else { hasSugar = false; };
			
			if (j == 0) { southDoor = false; } else { southDoor = true; }
			if (j == (numRooms - 1)) { northDoor = false; } else { northDoor = true; }
			
			toReturn[j] = new Room(hasCoffee, hasCream, hasSugar, northDoor, southDoor);
		}
		
		return toReturn;
	}
	
	
}
