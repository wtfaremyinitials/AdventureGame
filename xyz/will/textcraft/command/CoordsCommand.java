package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;

/**
 * Class CoordsCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will print the player's coordinates when executed.
 */
public class CoordsCommand extends Command {

	public CoordsCommand(String argument) {
		super(argument);
	}

	@Override
	public void run() {
		StringUtil.print("Your current coordinates are: " + player.getLocation().toString() + ".");
	}
	
}
