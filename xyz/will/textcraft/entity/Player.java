package xyz.will.textcraft.entity;

import java.util.HashMap;
import java.util.Map;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.World;

/**
 * Class Player
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This is currently the only subclass of Entity. It represents the character that
 * the user is able to control through commands.
 */
public class Player extends Entity {

	// The player's inventory, keys are the type of block and the value is the number the user has
	private Map<BlockType, Integer> inventory;
	// The block the player has in it's hand
	private BlockType hand;
	
	public Player(World world, Location location, Direction facing) {
		super(world, location, facing);
		inventory = new HashMap<BlockType, Integer>();
	}

	// Add an item to the player's inventory
	public void addItem(BlockType type, int amount) {
		// If the item type isn't already in the map, add it
		if(inventory.get(type) == null)
			inventory.put(type, 0);
		inventory.put(type, inventory.get(type) + 1);
	}
	
	// Add 1 of an item to the player's inventory
	public void addItem(BlockType type) {
		addItem(type, 1);
	}
	
	// Get the player's inventory
	public Map<BlockType, Integer> getInventory() {
		return inventory;
	}
	
	// Get the item the user is currently holding in their hand
	public BlockType getItemInHand() {
		return hand;
	}
	
	// Set the item the user is currently holding in their hand
	public void setItemInHand(BlockType hand) {
		this.hand = hand;
	}
	
}
