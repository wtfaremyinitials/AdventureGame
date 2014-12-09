package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;

/**
 * Class QuitCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will end the game when executed.
 */
public class QuitCommand extends Command {

	public QuitCommand(String argument) {
		super(argument);
	}

	public void run() {
		StringUtil.print("Thanks for playing!");
		System.exit(1);
	}

}
