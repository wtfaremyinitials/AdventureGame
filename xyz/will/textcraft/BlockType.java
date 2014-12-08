package xyz.will.textcraft;

public enum BlockType {

	AIR(0, "Air"),
	GRASS(1, "Grass"),
	DIRT(2, "Dirt"),
	WOOD(3, "Wood"),
	LEAVES(4, "Leaves"),
	STONE(5, "Stone"),
	DIAMOND(6, "Diamond");
	
	private int id;
	private String name;
	
	private BlockType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static BlockType fromID(int id) {
		for(BlockType t : values())
			if(t.id == id)
				return t;
		return null;
	}
	
	public static int getNumTypes() {
		return values().length;
	}
	
}
