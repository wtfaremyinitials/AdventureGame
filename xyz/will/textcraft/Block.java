package xyz.will.textcraft;

/**
 * Class Block
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This class represents a Block in the world that is currently loaded in memory.
 */
public class Block {

	// The coordinates of the block
	private int x;
	private int y;
	private int z;
	
	// The type of the block
	private BlockType type;
	
	// The world the block is in
	private World world;
	
	public Block(int x, int y, int z, BlockType type, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.type = type;
		
		this.world = world;
	}
	
	// Get the X coordinate of the block
	public int getX() {
		return x;
	}
	
	// Get the Y coordinate of the block
	public int getY() {
		return y;
	}
	
	// Get the Z coordinate of the block
	public int getZ() {
		return z;
	}
	
	// Get the BlockType of the block
	public BlockType getType() {
		return type;
	}
	
	// Set the BlockType of the block
	public void setType(BlockType type) {
		world.setBlockAt(new Location(x, y, z), type);
	}
	
}
