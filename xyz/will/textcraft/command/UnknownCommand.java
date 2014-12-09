package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;


public class UnknownCommand extends Command {

	public UnknownCommand(String argument) {
		super(argument);
	}

	public void run() {
		StringUtil.print("Unknown command.");
	}

}
