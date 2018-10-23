





public class PlanetExplorer {

	private int x;
	private int y;
	private int trenutnaX;
	private int trenutnaY;
	String obstacles;
	String facing="N";

	public PlanetExplorer(int x,int y){
		this.x=x;
		this.y=y;
		trenutnaX=0;
		trenutnaY=0;

	}
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x=x;
		this.y=y;
		this.obstacles=obstacles;
		trenutnaX=0;
		trenutnaY=0;


	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		if(command=="f")
		{
			if(trenutnaY==y-1)
			{
				trenutnaY=0;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";

			}else if(trenutnaX==x){

				trenutnaX=0;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";

			}else if(trenutnaX==0&&facing=="W"){

				trenutnaX=x-1;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";

			}else if(trenutnaX==x-1&&facing=="E"){

				trenutnaX=0;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";
			}
			else{

				trenutnaY++;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";
			}
		}
		if(command=="b")
		{
			if(trenutnaY==0)
			{
				trenutnaY=x-1;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";

			}else if(trenutnaX==0&&facing=="E"){

				trenutnaX=x-1;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";

			}else if(trenutnaX==x-1&&facing=="W"){

				trenutnaX=0;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";

			}
			else{

				trenutnaY--;
				return "("+trenutnaX+","+trenutnaY+","+facing+")";
			}
		}
		if(command=="r") 
		{
			facing="E";
			return "("+trenutnaX+","+trenutnaY+","+facing+")";
		}
		if(command=="l")
		{
			facing="W";
			return "("+trenutnaX+","+trenutnaY+","+facing+")";

		}


		return null;
	}
}
