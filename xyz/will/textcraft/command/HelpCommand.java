package xyz.will.textcraft.command;

import xyz.will.textcraft.*;

public class HelpCommand extends Command {

	public HelpCommand(String argument) {
		super(argument);
	}

	public void run() {		
		StringUtil.print("You are lost in an empty seeming world.");
	    StringUtil.print("");
	    StringUtil.print("Your command words are:");
	    StringUtil.print(StringUtil.join(" ", Game.getInstance().getParser().getCommandWords()));
	    StringUtil.print("Commands can be strung together in sequence with 'then'\ne.g: jump then place down");
	}
	
}
