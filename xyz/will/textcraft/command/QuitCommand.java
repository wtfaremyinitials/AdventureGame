package xyz.will.textcraft.command;

import xyz.will.textcraft.StringUtil;


public class QuitCommand extends Command {

	public QuitCommand(String argument) {
		super(argument);
	}

	public void run() {
		StringUtil.print("Thanks for playing!");
		System.exit(1);
	}

}
