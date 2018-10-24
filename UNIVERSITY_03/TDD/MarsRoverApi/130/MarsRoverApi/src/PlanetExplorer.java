




public class PlanetExplorer {
	int x,y;
	String smer;
	int pozicijaX,pozicijaY;
	String obstacles;


	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException{

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		if(this.x < 0 || this.y < 0){
			throw new PlanetExplorerException();
		}
		this.x = x;
		this.y = y;
		smer = "N";
		pozicijaX = 0;
		pozicijaY = 0;
		this.obstacles = obstacles;
	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		char[] komande = command.toCharArray();
		for(int i=0; i<komande.length;i++){
			if(komande[i] == 'f'){
				if(smer == "N"){
					pozicijaY++;
					if(pozicijaY == this.y){
						pozicijaY = 0;
					}
				}else if(smer == "S"){
					pozicijaY--;
					if(pozicijaY == -1){
						pozicijaY = this.y - 1;
					}
				}else if(smer == "E"){
					pozicijaX++;
					if(pozicijaX == this.x){
						pozicijaX = 0;
					}
				}else if(smer == "W"){
					pozicijaX--;
					if(pozicijaX == -1){
						pozicijaX = this.x - 1;
					}
				}
			}else if(komande[i] == 'b'){
				if(smer == "N"){
					pozicijaY--;
					if(pozicijaY == this.y){
						pozicijaY = 0;
					}
				}else if(smer == "E"){
					pozicijaX--;
				}else if(smer == "W"){
					pozicijaX++;
				}else if(smer == "S"){
					pozicijaY++;
				}
			}else if(komande[i] == 'l'){
				if(smer == "N"){
					smer = "W";
				}else if(smer == "S"){
					smer = "E";
				}else if(smer == "W"){
					smer = "S";
				}else if(smer == "E"){
					smer = "N";
				}
			}else if(komande[i] == 'r'){
				if(smer == "N"){
					smer = "E";
				}else if(smer == "S"){
					smer = "W";
				}else if(smer == "W"){
					smer = "N";
				}else if(smer == "E"){
					smer = "S";
				}
			}else{
				throw new PlanetExplorerException();
			}

		}

		return "("+pozicijaX+","+pozicijaY+","+smer+")";
	}

}
