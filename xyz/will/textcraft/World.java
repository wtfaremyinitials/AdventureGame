package xyz.will.textcraft;
import java.util.ArrayList;
import java.util.Random;

import xyz.will.textcraft.entity.Entity;
import xyz.will.textcraft.entity.Player;

public class World {

	private final int WORLD_SIZE	= 512;
	private final int WORLD_HEIGHT	= 256;
	
	private final int NUM_DIAMONDS	= 16;
	
	private byte[][][] blockIDArray;
	private ArrayList<Entity> entities;
	private Random rand;
	
	@SuppressWarnings("unused")
	private GravityThread gravity;
	
	public World() {
		blockIDArray = new byte[WORLD_SIZE][WORLD_HEIGHT][WORLD_SIZE];
		entities	 = new ArrayList<Entity>();
		gravity	     = new GravityThread(this);
		rand		 = new Random();
				
		generateWorld();
	}
	
	public static World readWorld() {
		return null;
	}
	
	private void generateWorld() {
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
	
		for(int i=0; i<NUM_DIAMONDS; i++)
			setBlockAt(getRandomLocation(), BlockType.DIAMOND);	
	}
	
	public Location getRandomLocation() {
		int x = rand.nextInt(WORLD_SIZE);
		int y = 12;
		int z = rand.nextInt(WORLD_SIZE);
		return new Location(x, y, z);
	}
	
	public Block getBlockAt(int x, int y, int z) {
		try {
			byte blockId = blockIDArray[x][y][z];
			return new Block(x, y, z, BlockType.fromID(blockId), this);
		} catch(IndexOutOfBoundsException e) { return new Block(x, y, z, BlockType.AIR, this); }
	}
	
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getX(), location.getY(), location.getZ());
	}
	
	public void setBlockAt(int x, int y, int z, BlockType type) {
		try {
			blockIDArray[x][y][z] = (byte) type.getID();
		} catch(IndexOutOfBoundsException e) {}
	}
	
	public void setBlockAt(Location loc, BlockType type) {
		setBlockAt(loc.getX(), loc.getY(), loc.getZ(), type);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void addEntity(Player player) {
		entities.add(player);
	}
	
	public int getHeight() {
		return WORLD_HEIGHT;
	}
	
	public int getSize() {
		return WORLD_SIZE;
	}
	
	public boolean isClear(Location loc) {
		return getBlockAt(loc).getType() == BlockType.AIR;
	}
	
}
