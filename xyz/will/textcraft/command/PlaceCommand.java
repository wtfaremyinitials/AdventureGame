package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

/**
 * Class PlaceCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will place the block that the player is currently holding back in to the world.
 */
public class PlaceCommand extends Command {

	public PlaceCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		// Get the direction the player specified
		String dirString = getArgument();
		
		// If the player didn't specify a location, yell at them
		if(dirString == null) {
			StringUtil.print("You must specify a direction!");
			return;
		}
		
		// Attempt to parse the passed location to a Direction
		Direction dir = Direction.fromString(dirString);
		
		// If what the user said wasn't a direction, yell at them 
		if(dir == null) {
			StringUtil.print("Unknown direction!");
			return;
		}
		
		// If the user hasn't chosen an item, yell at them
		if(player.getItemInHand() == null) {
			StringUtil.print("You must select an item first!");
			return;
		}
		
		// Get the number of the item the user has in their inventory
		Integer num = player.getInventory().get(player.getItemInHand());
		
		if(num == null) {
			StringUtil.print("You do not have any " + player.getItemInHand().getName().toLowerCase() + "!");
			return;
		}

		int count = (int) num;
		
		if(count == 0) {
			StringUtil.print("You do not have enough " + player.getItemInHand().getName().toLowerCase() + "!");
			return;
		}
		
		// Get the location of the block 1 block in the direction of the player's location
		Location loc = player.getLocation().add(dir, 1);
		
		
		// If there is a block in the way, yell at the user
		if(!world.isClear(loc)) {
			StringUtil.print("There is a block in the way!");
			return;
		}
		
		// Take 1 item from the player, and set the block in the world to the newly placed block
		world.setBlockAt(loc, player.getItemInHand());
		player.getInventory().put(player.getItemInHand(), count-1);
		
		// Tell the user that they placed a block
		StringUtil.print("You placed a block of " + player.getItemInHand().getName().toLowerCase() + " to the " + dirString.toLowerCase() + ".");
	}
	
}
