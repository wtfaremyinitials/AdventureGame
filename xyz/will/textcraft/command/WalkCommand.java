package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

/**
 * Class WalkCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command move the player 1 block in the given direction.
 */
public class WalkCommand extends Command {

	public WalkCommand(String argument) {
		super(argument);
	}

	
	public void run() {
		// Get the second word passed
		String dirString = getArgument();
		
		// If the user didn't pass a second word, get mad at them
		if(dirString == null) {
			StringUtil.print("You must specify a direction!");
			return;
		}
		
		// Attepmt to parse the second word to a Direction
		Direction dir = Direction.fromString(dirString);
		
		// If no matching Direction was found, tell the user that they're bad
		if(dir == null) {
			StringUtil.print("Unknown direction!");
			return;
		}
		
		// Get the location the player wants to move to
		Location loc = player.getLocation().add(dir, 1);
		
		// If there is something in the way, tell the user that their command was bad, and they should feel bad
		if(!world.isClear(loc)) {
			StringUtil.print("You would run in to something");
			return;
		}
		
		// Move the player to a new location
		player.setLocation(loc);
		
		// Inform the user of their triumph of moving 1 block
		StringUtil.print("You walked 1 block to the " + dirString.toLowerCase() + ".");
	}
	
}
