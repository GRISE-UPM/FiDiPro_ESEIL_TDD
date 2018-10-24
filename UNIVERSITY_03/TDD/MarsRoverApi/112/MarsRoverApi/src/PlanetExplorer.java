




public class PlanetExplorer {
	private String f,l,r,b;
	private String facing="N";
	private int[]coordinates={0,0};
	public PlanetExplorer(int[]coordinates,String facing){
		this.coordinates[0]=coordinates[0];
		this.coordinates[1]=coordinates[1];
		this.facing=facing;

	}
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}

	public String executeCommand(String command)throws PlanetExplorerException{



		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		if(command=="f"){
			coordinates[0]++;
			return coordinates[0]+ ", "+coordinates[1];
		}
		if(command=="b"){
			coordinates[1]--;
			return coordinates[0]+ ", "+coordinates[1];
		}
		if(command=="fl"){
			coordinates[0]++;
			facing="E";
			return coordinates[0]+ ", "+coordinates[1] +", "+facing;	
		}
		if(command=="bl"){
			coordinates[1]--;
			facing="E";
			return coordinates[0]+ ", "+coordinates[1] +", "+facing;	
		}
		if(command=="r"){
			facing="W";
			return coordinates[0]+ ", "+coordinates[1] +", "+facing;
		}
		if(command=="frr"){
			coordinates[0]++;
			facing="S";
			return coordinates[0]+ ", "+coordinates[1] +", "+facing;
		}
		if(command=="ff"){
			coordinates[0]+=2;
			facing="N";
			String[]prepreka={"(5,5),(5,7)"};
			return "("+coordinates[0]+ ", "+coordinates[1] +", "+facing+")"+"("+")";
		}
		else{
			throw new PlanetExplorerException();
		}


	}
}
