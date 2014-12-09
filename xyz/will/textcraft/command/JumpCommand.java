package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

public class JumpCommand extends Command {
	
	private static boolean firstJump = true;
	
	public JumpCommand(String argument) {
		super(argument);
	}
	
	public void run() {
		String dirString = getArgument();
		
		Direction dir = null;
		
		if(dirString != null) {
			dir = Direction.fromString(dirString);
			if(dir == null) {
				StringUtil.print("Unknown direction!");
			}
		}
		
		Location loc = player.getLocation().add(Direction.UP, 1);
		if(dir != null)
			loc = loc.add(dir, 1);
		
		if(!world.isClear(loc)) {
			StringUtil.print("You would run in to something");
			return;
		}
		
		player.setLocation(loc);
		
		if(dirString == null)
			StringUtil.print("You jumped.");
		else
			StringUtil.print("You jumped " + dirString.toLowerCase() + ".");
		
		if(firstJump && dirString == null)
			StringUtil.print("Hey! You can jump in directions as well.\ne.g: jump north");
		
		firstJump = false;
	}
	
}
