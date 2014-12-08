package xyz.will.textcraft;

public class Location {

	private int x;
	private int y;
	private int z;
	
	public Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public Location add(int x, int y, int z) {
		return new Location(this.x + x, this.y + y, this.z + z);
	}
	
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
	
	public String toString() {
		return x + " " + y + " " + z;
	}
	
}
