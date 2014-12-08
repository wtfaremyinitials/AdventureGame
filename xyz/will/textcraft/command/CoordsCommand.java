package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;

public class CoordsCommand extends Command {

	public CoordsCommand(String argument) {
		super(argument);
	}

	@Override
	public void run() {
		StringUtil.print("Your current coordinates are: " + player.getLocation().toString());
	}
	
}
