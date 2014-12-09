package xyz.will.textcraft.command;

import java.util.Map;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.StringUtil;

public class StuffCommand extends Command {

	public StuffCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		Map<BlockType, Integer> inventory = player.getInventory();
		
		String invString = "";
		
		for(int i=0; i<BlockType.getNumTypes(); i++) {
			BlockType type = BlockType.fromID(i);
			
			if(inventory.get(type) == null)
				continue;
			
			invString += inventory.get(type) + " " + type.getName().toLowerCase() + ", ";
		}
			
		if(invString.equals(""))
			invString = "an empty inventory.";
		else
			invString += "and nothing else.";
		
		StringUtil.print("You have " + invString);
	}
	
}
