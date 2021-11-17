package revature.project.colors;

import java.util.Scanner;

public class consoleColor {
   // Background
public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
public static final String RED_BACKGROUND = "\033[41m";    // RED
public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

// Regular Colors
public static final String BLACK = "\033[0;30m";   // BLACK
public static final String RED = "\033[0;31m";     // RED
public static final String GREEN = "\033[0;32m";   // GREEN
public static final String YELLOW = "\033[0;33m";  // YELLOW
public static final String BLUE = "\033[0;34m";    // BLUE
public static final String PURPLE = "\033[0;35m";  // PURPLE
public static final String CYAN = "\033[0;36m";    // CYAN
public static final String WHITE = "\033[0;37m";   // WHITE
public static final String GREY = "\033[0;90m";  // GREY


// Bold
public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
public static final String RED_BOLD = "\033[1;31m";    // RED
public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

// Underline
public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
public static final String RED_UNDERLINED = "\033[4;31m";    // RED
public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

// Declaring ANSI_RESET so that we can reset the color
public static final String ANSI_RESET = "\u001B[0m";
 
    
//    public static void main(String[] args)
//    {
//    	while(true) {
//    		Scanner sc = new Scanner(System.in);
//    		System.out.println(WHITE_BOLD+ BLACK_BACKGROUND
//                    + ":::WELCOME SCREEN:::\n"
//                    + ANSI_RESET+ PURPLE_BOLD
//                    +"Choose an option\n"
//                    + ANSI_RESET+BLUE+BLUE_UNDERLINED
//                    +"1. DEPOSTE\n"
//                    + "2. WITHDRAW\n"
//                    + "3. HOME\n"
//                    + "4.HELP "
//                    +ANSI_RESET);
//    		int option = sc.nextInt();
//    		switch (option) 
//    		{
//			case 1:System.out.println(GREEN+ consoleColor.class +" Deposite ");break;
//
//			case 2:System.out.println(GREEN+ consoleColor.class +"Withdraw");break;
//
//			case 3:System.out.println(GREEN+ consoleColor.class +"Home");break;
//
//			case 4:System.out.println(CYAN_BOLD+"[name=bob heigth=6.1 age=31]\n"
//	    			+"[name=bob heigth=6.1 age=31]\n"
//	    			+"[name=bob heigth=6.1 age=31]\n"
//	    			+"[name=bob heigth=6.1 age=31]\n"
//	    			+ANSI_RESET);break;
//			
//			default:System.err.println("Invalide option\n");
//			}
//    	} 
//    	
//    }
	
}
