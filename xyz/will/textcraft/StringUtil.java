package xyz.will.textcraft;

/**
 * Class StringUtil
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This contains a couple of utility methods for dealing with strings
 */
public class StringUtil {

	// The time in between letters when printing a string to the terminal
	private static final int TEXT_SPEED = 30; // http://i.imgur.com/jnasdjM.png
	
	// Print a message to the terminal 1 letter at a time
	public static void print(String str) {
    	try {
    		// Iterate over each letter, printing 1 at a time
    		for(int i=0; i<str.length(); i++) {
    			System.out.print(str.charAt(i));
    			Thread.sleep(TEXT_SPEED);
        	}
    		// Spit out a newline at the end
    		System.out.print("\n");
		} catch (InterruptedException e) { e.printStackTrace(); }    	
	}
	
	// Join an array of strings with a given string in between each item in the array
	public static String join(String between, String[] array) {
		String out = "";
		for(String str : array)
			out = out + between + str;
		return out;
	}
	
}
