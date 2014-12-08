package xyz.will.textcraft.command;


public class UnknownCommand extends Command {

	public UnknownCommand(String argument) {
		super(argument);
	}

	public boolean isUnknown() {
		return true;
	}

	public void run() {
	}

}
