package xyz.will.textcraft.command;

import java.awt.Desktop;
import java.net.URI;

import xyz.will.textcraft.StringUtil;

/**
 * Class CoordsCommand
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This command will rickroll the user when executed.
 */
public class RickrollCommand extends Command {

	public RickrollCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		// Open the classic rickroll video in the user's favorite browser
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
	        } catch (Exception e) { e.printStackTrace(); }
	    }
	    // Tease the user
	    StringUtil.print("Congratz. You've been rickrolled.");
	}
	
}
