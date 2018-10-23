




public class PlanetExplorer {

	private int x;
	private int y;
	private String obstracles;
	private String komanda;
	int i,j;

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x= x;
		this.y= y;
		this.obstracles= obstracles;

	}

	 * Example: 
	 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
	 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
	 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 *
	public String executeCommand(String command){




		switch(komanda) 
		{

		case "l":
			if(komanda == "l") {
			} break;
		case "r":
			if(komanda == "r") {
				for(i = 0; i<0;)
				{
					for(j=0; j<1;){
						j++;
					}
				}
			} break;
		case "f":
			if(komanda == "f") {
				for(i = 0; i<2;)
				{
					for(j=0; j<2;){
						j++;
						i++;
					}
				}
			} break;
		case "b":
			} break;


		return null;
	}
	*
}
