package xyz.will.textcraft.command;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.StringUtil;

public class PlaceCommand extends Command {

	public PlaceCommand(String argument) {
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
		
		if(player.getItemInHand() == null) {
			StringUtil.print("You must select an item first!");
			return;
		}
		
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
		
		Location loc = player.getLocation().add(dir, 1);
		
		if(!world.isClear(loc)) {
			StringUtil.print("There is a block in the way!");
			return;
		}
		
		world.setBlockAt(loc, player.getItemInHand());
		player.getInventory().put(player.getItemInHand(), count-1);
		
		StringUtil.print("You placed a block of " + player.getItemInHand().getName().toLowerCase() + " to the " + dirString.toLowerCase() + ".");
	}
	
}
