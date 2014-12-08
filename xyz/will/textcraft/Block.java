package xyz.will.textcraft;

public class Block {

	private int x;
	private int y;
	private int z;
	
	private BlockType type;
	
	private World world;
	
	public Block(int x, int y, int z, BlockType type, World world) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.type = type;
		
		this.world = world;
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
	
	public BlockType getType() {
		return type;
	}
	
	public void setType(BlockType type) {
		world.setBlockAt(x, y, z, type);
	}
	
}
