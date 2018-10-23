package main;





public class PlanetExplorer {

	int xPos = 0;
	int yPos = 0;
	int len;
	int wid;
	String facing = "N";

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *
		int len = x;
		int wid = y;

		int xPos = 0;
		int yPos = 0;
		String facing = "N";

	}




	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		 if(command=="f" && this.facing=="N"){
			 this.xPos++;
		 }
		 if(command=="r" && this.facing=="N"){
			 this.facing = "E";
		 }
		 if(command=="l" && this.facing=="N"){
			 this.facing = "W";
		 }
		 if(command=="b" && this.facing=="N"){
			 if(this.xPos==0){
				 this.xPos = this.len;
			 } else
			   this.xPos--;

		 }




		return ("("+this.xPos+", "+this.yPos+", "+this.facing+")");
	}
}
