package xyz.will.textcraft.command;

import java.util.Map;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.StringUtil;

/**
 * Class StuffCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will print the player's inventory when executed.
 */
public class StuffCommand extends Command {

	public StuffCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		// Get the player's inventory
		Map<BlockType, Integer> inventory = player.getInventory();
		
		// Initialize a string to store the output
		String invString = "";
		
		// Iterate over all item types, and add items the user has to the output
		for(int i=0; i<BlockType.values().length; i++) {
			BlockType type = BlockType.fromID(i);
			
			if(inventory.get(type) == null)
				continue;
			
			invString += inventory.get(type) + " " + type.getName().toLowerCase() + ", ";
		}
		
		// If no items were found, tell the user that they don't have anything
		if(invString.equals(""))
			invString = "an empty inventory.";
		else
			invString += "and nothing else.";
		
		// Print the output
		StringUtil.print("You have " + invString);
	}
	
}
