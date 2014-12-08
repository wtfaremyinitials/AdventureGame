package xyz.will.textcraft.entity;

import java.util.HashMap;
import java.util.Map;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.World;

public class Player extends Entity {

	private Map<BlockType, Integer> inventory;
	
	public Player(World world, Location location, Direction facing) {
		super(world, location, facing);
		inventory = new HashMap<BlockType, Integer>();
	}

	public void addItem(BlockType type, int amount) {
		if(inventory.get(type) == null)
			inventory.put(type, 0);
		inventory.put(type, inventory.get(type) + 1);
	}
	
	public void addItem(BlockType type) {
		addItem(type, 1);
	}
	
	public Map<BlockType, Integer> getInventory() {
		return inventory;
	}
	
}
