

public class Color{
	
	public static String RESET = "\u001b[0m";
	public static String BLACK = "\u001b[30m";
	public static String GREEN = "\u001b[32m";
	public static String RED = "\u001b[31m";
	public static String BLUE = "\u001b[34m";
	public static String YELLOW = "\u001b[33m";
	public static String MAGENTA = "\u001b[35m";
	public static String CYAN = "\u001b[36m";
	public static String WHITE = "\u001b[37m";


	public static String BRIGHT_BLACK = "\u001b[30;1m";
	public static String BRIGHT_RED = "\u001b[31;1m";
	public static String BRIGHT_GREEN = "\u001b[32;1m";
	public static String BRIGHT_YELLOW = "\u001b[33;1m";
	public static String BRIGHT_BLUE = "\u001b[34;1m";
	public static String BRIGHT_MAGENTA = "\u001b[35;1m";
	public static String BRIGHT_CYAN = "\u001b[36;1m";
	public static String BRIGHT_WHITE = "\u001b[37;1m";
		
		
	public static String BACKGROUND_BLACK = "\u001b[40m";
	public static String BACKGROUND_RED = "\u001b[41m";
	public static String BACKGROUND_GREEN = "\u001b[42m";
	public static String BACKGROUND_YELLOW = "\u001b[43m";
	public static String BACKGROUND_BLUE = "\u001b[44m";
	public static String BACKGROUND_MAGENTA = "\u001b[45m";
	public static String BACKGROUND_CYAN = "\u001b[46m";
	public static String BACKGROUND_WHITE = "\u001b[47m";


	public static String BACKGROUND_BRIGHT_BLACK = "\u001b[40;1m";
	public static String BACKGROUND_BRIGHT_RED = "\u001b[41;1m";
	public static String BACKGROUND_BRIGHT_GREEN = "\u001b[42;1m";
	public static String BACKGROUND_BRIGHT_YELLOW = "\u001b[43;1m";
	public static String BACKGROUND_BRIGHT_BLUE = "\u001b[44;1m";
	public static String BACKGROUND_BRIGHT_MAGENTA = "\u001b[45;1m";
	public static String BACKGROUND_BRIGHT_CYAN = "\u001b[46;1m";
	public static String BACKGROUND_BRIGHT_WHITE = "\u001b[47;1m";

	public static void setColor( String color ){
		System.out.printf( "%s", color );
	}
	
	public static void resetColor(){
		System.out.printf( "%s", Color.RESET  );
	}
	
	
	public static void cursorUp(){
		
	}
	
	public static void cursorDown(){
		
	}
}