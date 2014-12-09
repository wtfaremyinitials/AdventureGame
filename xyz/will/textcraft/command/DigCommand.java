package xyz.will.textcraft.command;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

/**
 * Class DigCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will remove one block in any direction and add it to the player's inventory.
 */
public class DigCommand extends Command {

	public DigCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		// Get the second word passed
		String dirString = getArgument();
		
		// Check if it is null, if it, yell at the user
		if(dirString == null) {
			StringUtil.print("You must specify a direction!");
			return;
		}
		
		// Convert the second word to a Direction
		Direction dir = Direction.fromString(dirString);
		
		// If there was no direction that matched the given string, yell at the user
		if(dir == null) {
			StringUtil.print("Unknown direction!");
			return;
		}
		
		// Get the location of the block the player is trying to dig
		Location loc = player.getLocation().add(dir, 1);
		
		// If that block is air, inform the user that they cannot break air
		if(world.isClear(loc)) {
			StringUtil.print("You cannot break air");
			return;
		}
		
		// Get the type of the block already there
		BlockType type = world.getBlockAt(loc).getType();
		
		// Give the player 1 of that type, and replace the block with air
		player.addItem(type);
		world.setBlockAt(loc, BlockType.AIR);
		
		// Inform the user of their success
		StringUtil.print("You broke a block of " + type.getName().toLowerCase() + ".");
		
		// If the player mined a diamond, tell them they've won.
		if(type == BlockType.DIAMOND)
			StringUtil.print("You win! You may continue playing, or type \"quit\" to quit.");
	}
	
}
