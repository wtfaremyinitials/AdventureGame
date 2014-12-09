package xyz.will.textcraft.command;

import xyz.will.textcraft.BlockType;
import xyz.will.textcraft.StringUtil;

public class SelectCommand extends Command {

	public SelectCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		String typeStr = getArgument();
		
		if(typeStr == null) {
			StringUtil.print("You must specify an item!");
			return;
		}
		
		BlockType type = BlockType.fromName(typeStr);
		
		if(type == null) {
			StringUtil.print("That's not a valid item type!");
			return;
		}
		
		player.setItemInHand(type);
		
		StringUtil.print("You put " + type.getName().toLowerCase() + " in your hand.");
	}
	
}
