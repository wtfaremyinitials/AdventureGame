package xyz.will.textcraft.command;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.StringUtil;

/**
 * Class SelectCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command put an item in to the player's hand.
 */
public class SelectCommand extends Command {

	public SelectCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		// Get the second argument passed
		String typeStr = getArgument();
		
		// If the user didn't specify, scold them for being a bad user
		if(typeStr == null) {
			StringUtil.print("You must specify an item!");
			return;
		}
		
		// Attempt to parse the argument to a BlockType
		BlockType type = BlockType.fromName(typeStr);
		
		// If it was not a valid BlockType, scold the user again
		if(type == null) {
			StringUtil.print("That's not a valid item type!");
			return;
		}
		
		// Set the item in the player's hand to the given BlockType
		player.setItemInHand(type);
		
		// Tell the user they succeeded
		StringUtil.print("You put " + type.getName().toLowerCase() + " in your hand.");
	}
	
}
