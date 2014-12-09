package xyz.will.textcraft.command;

import java.awt.Desktop;
import java.net.URI;

import xyz.will.textcraft.StringUtil;

public class RickrollCommand extends Command {

	public RickrollCommand(String argument) {
		super(argument);
	}
	
	@Override
	public void run() {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
	        } catch (Exception e) { e.printStackTrace(); }
	    }
	    StringUtil.print("Congratz. You've been rickrolled.");
	}
	
}
