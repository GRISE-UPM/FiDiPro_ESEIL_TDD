






public class PlanetExplorer {


	int xRover;
	int yRover;

	String obstacles;
	String [] diresctions = {"N","E","S","W"};
	String direction;

	boolean check=false;

	public PlanetExplorer(int x, int y, String obstacles)throws PlanetExplorerException{

		 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
		 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

		 *		if(x<=3 && y<=3){
			xRover=x;
			yRover=y;
			this.obstacles=obstacles;
			direction=diresctions[0];
		}

		else{
			throw new PlanetExplorerException();
		}

	}

	public String executeCommand(String command)throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		int x=0;
		char [] com = command.toCharArray();
		for(int i=0;i<com.length;i++){
			if(com[i]=='f'){
				if(direction=="N"){
					if(yRover==3){

						yRover=0;
					}
					else
						yRover++;
				}
				if(direction=="E"){
					if(xRover==3){
						xRover=0;
					}
					else
						xRover++;
				}
				if(direction=="S"){
					if(yRover==0){

						yRover=3;
					}
					else
						yRover--;
				}
				if(direction=="W"){
					if(xRover==0){
						xRover=3;
					}
					else
						xRover--;
				}
			}
			else if(com[i]=='b'){
				if(direction=="N"){
					if(yRover==0){
						yRover=3;
					}
					else
						yRover--;
				}
				if(direction=="E"){
					if(xRover==0)
						xRover=3;
					else
						xRover--;
				}
				if(direction=="S"){
					if(yRover==3)
						yRover=0;
					else
						yRover++;
				}
				if(direction=="W"){
					if(xRover==3)
						xRover=0;
					else
						xRover++;
				}
			}
			else if(com[i]=='r'){
				if(x==3){
					x=0;
					direction=diresctions[x];
				}
				else{
					x++;
					direction=diresctions[x];
				}

			}
			else if(com[i]=='l'){
				if(x==0){
					x=3;
					direction=diresctions[x];
				}
				else{
					x--;
					direction=diresctions[x];
				}
			}
			else if(com[i]=='s'){
				return "("+String.valueOf(xRover)+","+String.valueOf(yRover)+","+direction+")("+obstacles+")";
			}
			else{
				throw new PlanetExplorerException();
			}




		}
		return "("+String.valueOf(xRover)+","+String.valueOf(yRover)+","+direction+")("+obstacles+")";

	}
	public void check_obstacle(boolean check){

	}
}
