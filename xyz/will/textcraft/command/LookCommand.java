package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

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
	
	private String nameAt(Location loc, Direction dir) {
		return world.getBlockAt(loc.add(dir, 1)).getType().getLongName().toLowerCase();
	}
	
}
