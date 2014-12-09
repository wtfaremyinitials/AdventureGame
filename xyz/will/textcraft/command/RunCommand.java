package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

/**
 * Class CoordsCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will move the player 3 blocks in the direction specified.
 */
public class RunCommand extends Command {

	public RunCommand(String argument) {
		super(argument);
	}

	
	public void run() {
		// Get the second word the user passed
		String dirString = getArgument();
		
		// If the user didn't choose a direction, yell at them
		if(dirString == null) {
			StringUtil.print("You must specify a direction!");
			return;
		}
		
		// Attempt to parse the direction 
		Direction dir = Direction.fromString(dirString);
		
		// If it was not a valid direction, yell at the user
		if(dir == null) {
			StringUtil.print("Unknown direction!");
			return;
		}
		
		// Get the direction the player is trying to move to
		Location loc = player.getLocation().add(dir, 3);

		// If there is something in the way, tell the user
		if(!world.isClear(loc)) {
			StringUtil.print("You would run in to something");
			return;
		}
		
		// Move the player to the new location
		player.setLocation(loc);
		
		// Inform the user of their success
		StringUtil.print("You ran 3 blocks to the " + dirString.toLowerCase() + ".");
	}
}
