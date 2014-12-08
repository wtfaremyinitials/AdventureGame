package xyz.will.textcraft;

public class StringUtil {

	public static void print(String str) {
    	try {
    		for(int i=0; i<str.length(); i++) {
    			System.out.print(str.charAt(i));
    			Thread.sleep(10);
        	}
    		System.out.println("");
		} catch (InterruptedException e) { e.printStackTrace(); }    	
	}
	
	public static String join(String between, String[] array) {
		String out = "";
		for(String str : array)
			out = out + between + str;
		return out;
	}
	
}
