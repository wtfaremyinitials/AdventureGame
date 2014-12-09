package xyz.will.textcraft;

/**
 * Class Locatio 
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * Location is an immutable class used to store and manipulate X, Y, and Z coordinates
 */
public class Location {

	// X, Y, and Z coordinates 
	private int x;
	private int y;
	private int z;
	
	public Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// Get the X coordinate
	public int getX() {
		return x;
	}
	
	// Get the Y coordinate
	public int getY() {
		return y;
	}
	
	// Get the Z coordinate
	public int getZ() {
		return z;
	}
	
	// Return a new Location based on the given deltas
	public Location add(int deltaX, int deltaY, int deltaZ) {
		return new Location(x + deltaX, y + deltaY, z + deltaZ);
	}
	
	// Return a new Location based on a given Direction, and a number of blocks to move
	public Location add(Direction direction, int x) {
		int deltaX = 0;
		int deltaY = 0;
		int deltaZ = 0;
		
		if(direction == Direction.NORTH)
			deltaX =  x;
		if(direction == Direction.EAST)
			deltaZ =  x;
		if(direction == Direction.SOUTH)
			deltaX = -x;
		if(direction == Direction.WEST)
			deltaZ = -x;
		if(direction == Direction.UP)
			deltaY =  x;
		if(direction == Direction.DOWN)
			deltaY = -x;
		
		return this.add(deltaX, deltaY, deltaZ);
	}
	
	// Concatenate all 3 coordinates to a string
	public String toString() {
		return x + " " + y + " " + z;
	}
	
}
