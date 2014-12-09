package xyz.will.textcraft;

/**
 * Enumeration BlockType
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This enum stores all of the possible block types.
 */
public enum BlockType {

	// Define block types
	AIR(0, "Air"),
	GRASS(1, "Grass"),
	DIRT(2, "Dirt"),
	WOOD(3, "Wood"),
	LEAVES(4, "Leaves"),
	STONE(5, "Stone"),
	DIAMOND(6, "Diamond");
	
	// The ID of the block
	private int id;
	// The name of the block
	private String name;
	
	private BlockType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Get the ID of the block
	public int getID() {
		return id;
	}
	
	// Get the name of the block
	public String getName() {
		return name;
	}
	
	// Get the fancy name of the block, used in LookCommand
	public String getLongName() {
		if(this == BlockType.AIR)
			return "nothing but air";
		if(this == BlockType.DIAMOND)
			return "sparkling diamonds";	
		return name;
	}
	
	// Get a BlockType from an ID
	public static BlockType fromID(int id) {
		for(BlockType t : values())
			if(t.id == id)
				return t;
		return null;
	}
	
	// Get a BlockType from a name
	public static BlockType fromName(String name) {
		for(BlockType t : values())
			if(t.getName().equalsIgnoreCase(name))
				return t;
		return null;
	}
	
}
