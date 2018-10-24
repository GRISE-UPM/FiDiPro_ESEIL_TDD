
public class Util {
	public static final char MOVEFORWARD = 'f';
	public static final char MOVEBACKWARD = 'b';
	public static final char MOVELEFT = 'l';
	public static final char MOVERIGHT = 'r';

	public static String cycleDirectionLeft(String dir){
		String returnDir = dir;
		switch(returnDir){
		case "N": returnDir = "W"; break;
		case "W": returnDir = "S"; break;
		case "S": returnDir = "E"; break;
		case "E": returnDir = "N"; break;
		}
		return returnDir;
	}

	public static String cycleDirectionRight(String dir){
		String returnDir = dir;
		switch(returnDir){
		case "N": returnDir = "E"; break;
		case "E": returnDir = "S"; break;
		case "S": returnDir = "W"; break;
		case "W": returnDir = "N"; break;
		}
		return returnDir;
	}

	public static int countNumOfMovement(String in, String chars){
		return in.length() - chars.replace(chars, "").length();
	}

	public static String formatPosition(int x, int y){	
		return "(" + x + "," + y + ")";
	}

	public static String formatPositionWithDir(int x, int y, String dir){	
		return "(" + x + "," + y + ","+ dir +")";
	}

	public static boolean isInteger(String test) {
		return isInteger(test, 10);
	}

	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}


}
