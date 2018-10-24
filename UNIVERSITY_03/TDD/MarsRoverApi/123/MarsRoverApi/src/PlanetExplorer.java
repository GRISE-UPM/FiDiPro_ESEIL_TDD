




public class PlanetExplorer {
	private int x,y;
	private int pos_x, pos_y = 0;
	private String facing = "N";
	private String obstacles;

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x=x;
		this.y=y;
		this.obstacles=obstacles;


	}

	public void sphericForward(int pos_y){
		if(pos_y >3 ){
			this.pos_y=0;
		}

	}

	public void sphericBack(int pos_y){
		if(pos_y <0 ){
			this.pos_y=3;
		}

	}



	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		char[] cmd = command.toCharArray();
		for(int i=0; i<command.length(); i++){



			if(cmd[i] == 'f'){

				pos_y+=1;
				sphericForward(pos_y);

			} else if (cmd[i] == 'b'){
				pos_y-=1;
				sphericBack(pos_y);
			}

		}

		for(int i = 0; i<cmd.length; i++){
			if(command == "r"){
				facing = "E";

			} else if (command == "l"){
				facing = "W";
			}
		}





		return "("+pos_x+","+pos_y+","+facing+")";
	}
}
