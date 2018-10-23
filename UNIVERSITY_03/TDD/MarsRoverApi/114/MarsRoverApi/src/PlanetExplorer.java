








public class PlanetExplorer {

	int pos_x=0;
	int pos_y=0;

	String direction="N";

	public PlanetExplorer(int x, int y, String obstacles){
		pos_x=x;
		pos_y=y;
		obstacles=obstacles;

	}

	public String executeCommand(String command) {		char[]com=command.toCharArray();
		for(int i=0;i<com.length;i++){
		if(com[i]=='f'){
			direction="N";
				pos_y++;
			}
		else if(com[i]=='b'){
			direction="S";
			pos_y--;
		}
		else if(com[i]=='l'){
			direction="W";
			pos_x--;
		}
		else if(com[i]=='d'){
			direction="E";
			pos_x++;
		}
		else{

		}
		}

		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return toString();
	}

	public String toString(){
		return "("+pos_x+","+pos_y+","+direction+")";
	}
}
