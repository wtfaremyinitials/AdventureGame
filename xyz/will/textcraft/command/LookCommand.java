package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

/**
 * Class LookCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will tell the player what is immediately around them.
 */
public class LookCommand extends Command {

	public LookCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		Location loc = player.getLocation();
		StringUtil.print("You're standing on " + nameAt(loc, Direction.DOWN) + ".");
		StringUtil.print("There's " + nameAt(loc, Direction.EAST) + " immediately to the East,");
		StringUtil.print("as well as " + nameAt(loc, Direction.WEST) + " immediately to the West.");
		StringUtil.print("You look up and see " + nameAt(loc, Direction.UP) + ".");
		StringUtil.print("You turn your head North and see " + nameAt(loc, Direction.NORTH) + ".");
		StringUtil.print("And to your south is " + nameAt(loc, Direction.SOUTH) + ".");
	}
	
	// Take a location and a direction, and return the name of the block 1 block to the given direction of the location
	private String nameAt(Location loc, Direction dir) {
		return world.getBlockAt(loc.add(dir, 1)).getType().getLongName().toLowerCase();
	}
	
}
