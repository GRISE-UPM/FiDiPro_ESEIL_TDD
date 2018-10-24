





public class PlanetExplorer {
	int voziloX;
	int voziloY;
	String smer;
	boolean smerPoY; 
	int x;
	int y;
	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException{

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		if (x<0 || y <0) {
			throw new PlanetExplorerException();
		}
		this.x=x;
		this.y=y;
		voziloX = 0;
		voziloY = 0;
		smer = "N";
		smerPoY = true;
	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		for (int i = 0; i < command.length(); i++) {
			char com = command.charAt(i);
			if(com == 'f'){
				if (smerPoY && voziloY == y) {
					voziloY = 0;
				} else if (smerPoY == false && voziloX == x) {
					voziloX = 0;
				} else {
					if (smerPoY) {
						voziloY++;
					} else {
						voziloX++;
					}
				}

			} else if (com == 'b') {

				if (smerPoY && voziloY == 0) {
					voziloY = y-1;
				} else if (smerPoY == false && voziloX == 0) {
					voziloX = x-1;
				} else {
					if (smerPoY) {
						voziloY--;
					} else {
						voziloX--;
					}
				}
			} else if (com == 'r') {
				if(smer == "N") {
					smer = "E";
					smerPoY=false;
				} else if(smer == "E") {
					smer = "S";
					smerPoY=true;
				} else if(smer == "S") {
					smer = "W";
					smerPoY=false;
				} else if(smer == "W") {
					smer = "N";
					smerPoY=true;
				}
			} else if (com == 'l') {
				if(smer == "N") {
					smer = "W";
					smerPoY=false;
				} else if(smer == "E") {
					smer = "N";
					smerPoY=true;
				} else if(smer == "S") {
					smer = "E";
					smerPoY=false;
				} else if(smer == "W") {
					smer = "S";
					smerPoY=true;
				}
			}
		}
		String result = "(" + voziloX + ","+ voziloY+ "," + smer+")";


		return result;
	}
}
