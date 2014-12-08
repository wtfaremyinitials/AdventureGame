package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;

public class LookCommand extends Command {

	public LookCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		StringUtil.print(world.getBlockAt(player.getLocation()).getType().getName());
		StringUtil.print(world.getBlockAt(player.getLocation().add(0, -1, 0)).getType().getName());
	}
	
}
