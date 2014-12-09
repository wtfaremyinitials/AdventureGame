package xyz.will.textcraft;
import java.util.ArrayList;
import java.util.Random;

import xyz.will.textcraft.entity.Entity;
import xyz.will.textcraft.entity.Player;

/**
 * Class World
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This class holds all of the information about the world the user is interacting with.
 */
public class World {

	// The dimensions of the world
	private final int WORLD_SIZE	= 512;
	private final int WORLD_HEIGHT	= 256;
	
	// The number of diamonds (win condition) to generate in the world
	private final int NUM_DIAMONDS	= 16;
	
	// The three dimensional array that stores all of the blocks in the 3D world
	private byte[][][] blockIDArray;
	// The array(list) of Entity's in the World
	private ArrayList<Entity> entities;
	// A Random object used for world generation
	private Random rand;
	
	// Instantiate variables, start GravityThread, generate a new world
	public World() {
		blockIDArray = new byte[WORLD_SIZE][WORLD_HEIGHT][WORLD_SIZE];
		entities	 = new ArrayList<Entity>();
		rand		 = new Random();
		
        new GravityThread(this);
				
		generateWorld();
	}
	
	// TODO: Deserialize a world from a File
	public static World readWorld() {
		return null;
	}
	
	// Generate a 3 dimensional world
	// Layers:
	// 	256-129: Air
	//  128:     Grass
	//  127-124: Stone
	//  12 (randomly placed): Diamond
	private void generateWorld() {
		// Loop through all block locations where a block needs to be generated
		for(int x=0; x<WORLD_SIZE; x++) {
			for(int z=0; z<WORLD_SIZE; z++) {
				for(int y=0; y<WORLD_HEIGHT/2; y++) {
					setBlockAt(x, y, z, BlockType.STONE);
					if(y > (WORLD_HEIGHT/2) - 5)
						setBlockAt(x, y, z, BlockType.DIRT);
					if(y == (WORLD_HEIGHT/2) -1)
						setBlockAt(x, y, z, BlockType.GRASS);
				}
			}
		}
	
		// Generate NUM_DIAMONDS of diamonds in random locations
		for(int i=0; i<NUM_DIAMONDS; i++)
			setBlockAt(getRandomLocation(), BlockType.DIAMOND);	
	}
	
	// Generate a random location
	public Location getRandomLocation() {
		int x = rand.nextInt(WORLD_SIZE);
		int y = 12;
		int z = rand.nextInt(WORLD_SIZE);
		return new Location(x, y, z);
	}
	
	// Get the Block at given coordinates
	private Block getBlockAt(int x, int y, int z) {
		try {
			byte blockId = blockIDArray[x][y][z];
			return new Block(x, y, z, BlockType.fromID(blockId), this);
		} catch(IndexOutOfBoundsException e) { return new Block(x, y, z, BlockType.AIR, this); }
	}
	
	// Get the Block at the given Location
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getX(), location.getY(), location.getZ());
	}
	
	// Set the BlockType at given coordinates
	private void setBlockAt(int x, int y, int z, BlockType type) {
		try {
			blockIDArray[x][y][z] = (byte) type.getID();
		} catch(IndexOutOfBoundsException e) {}
	}
	
	// Set the BlockType at given Location
	public void setBlockAt(Location loc, BlockType type) {
		setBlockAt(loc.getX(), loc.getY(), loc.getZ(), type);
	}
	
	// Get the ArrayList of Entity's in the world
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	// Add a new Entity to the world
	public void addEntity(Player player) {
		entities.add(player);
	}
	
	// Get the world's height
	public int getHeight() {
		return WORLD_HEIGHT;
	}
	
	// Get the world's size
	public int getSize() {
		return WORLD_SIZE;
	}
	
	// Check if a location is clear of any blocks
	public boolean isClear(Location loc) {
		return getBlockAt(loc).getType() == BlockType.AIR;
	}
	
}
