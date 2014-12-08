package xyz.will.textcraft;

public enum Direction {

	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3),
	UP(4),
	DOWN(5);
	
	private int id;
	
	private Direction(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public static Direction fromString(String str) {
		if(str.equalsIgnoreCase("north"))
			return NORTH;
		if(str.equalsIgnoreCase("south"))
			return SOUTH;
		if(str.equalsIgnoreCase("east"))
			return EAST;
		if(str.equalsIgnoreCase("west"))
			return WEST;
		if(str.equalsIgnoreCase("up"))
			return UP;
		if(str.equalsIgnoreCase("down"))
			return DOWN;
		return null;
	}
	
}
