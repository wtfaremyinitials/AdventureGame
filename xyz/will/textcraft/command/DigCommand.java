package xyz.will.textcraft.command;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

public class DigCommand extends Command {

	public DigCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		String dirString = getArgument();
		
		if(dirString == null) {
			StringUtil.print("You must specify a direction!");
			return;
		}
		
		Direction dir = Direction.fromString(dirString);
		
		if(dir == null) {
			StringUtil.print("Unknown direction!");
			return;
		}
		
		Location loc = player.getLocation().add(dir, 1);
		
		if(world.isClear(loc)) {
			StringUtil.print("You cannot break air");
			return;
		}
		
		player.addItem(world.getBlockAt(loc).getType());
		world.setBlockAt(loc, BlockType.AIR);
	}
	
}
