package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

/**
 * Class JumpCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command move the user's location 1 block up and 1 block in any direction specified.
 */
public class JumpCommand extends Command {
	
	// Stores weather or not the user has run any instance of the jump command before
	private static boolean firstJump = true;
	
	public JumpCommand(String argument) {
		super(argument);
	}
	
	public void run() {
		// Get the string passed as the seonc
		String dirString = getArgument();
		
		// Initialize the direction variable
		Direction dir = null;
		
		// If the user passed a second word, attempt to parse it to a Direction
		if(dirString != null) {
			dir = Direction.fromString(dirString);
			if(dir == null) {
				StringUtil.print("Unknown direction!");
			}
		}
		
		// Get the location of 1 block above the player, and add the optional 1 block in any direction
		Location loc = player.getLocation().add(Direction.UP, 1);
		if(dir != null)
			loc = loc.add(dir, 1);
		
		// If the block is not clear (i.e: something is in the way), stop the player from moving 
		if(!world.isClear(loc)) {
			StringUtil.print("You would run in to something");
			return;
		}
		
		// Move the player to their new location
		player.setLocation(loc);
		
		// Tell the user where they jumped to
		if(dirString == null)
			StringUtil.print("You jumped.");
		else
			StringUtil.print("You jumped " + dirString.toLowerCase() + ".");
		
		// If this is the player's first time jumping and they didn't specify a direction,
		// inform them that they can pass a direction as a second argument
		if(firstJump && dirString == null)
			StringUtil.print("Hey! You can jump in directions as well.\ne.g: jump north");
		firstJump = false;
	}
	
}
