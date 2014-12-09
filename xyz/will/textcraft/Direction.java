package xyz.will.textcraft;

/**
 * Enumeration Direction
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This enum stores all of the possible directions.
 */
public enum Direction {

	// Define directions
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3),
	UP(4),
	DOWN(5);
	
	// The ID of the direction
	private int id;

	private Direction(int id) {
		this.id = id;
	}

	// Get the ID of a Direction
	public int getID() {
		return this.id;
	}
	
	// Get a Direction from a String
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
