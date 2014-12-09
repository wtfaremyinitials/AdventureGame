package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;

/**
 * Class UnknownCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command is chosen when the user types a word that is not a command.
 * When it is executed, it will simply print "Unknown command."
 */
public class UnknownCommand extends Command {

	public UnknownCommand(String argument) {
		super(argument);
	}

	public void run() {
		StringUtil.print("Unknown command.");
	}

}
