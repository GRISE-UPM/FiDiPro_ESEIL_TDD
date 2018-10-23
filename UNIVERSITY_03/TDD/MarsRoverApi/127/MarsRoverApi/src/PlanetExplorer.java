




public class PlanetExplorer {
	private int gridX;
	private int gridY;

	private int planetX=0;
	private int planetY=0;

	private String[] side = {"N","S","E","W"};

	private String planetSide=side[0];

	private String[] obstaclesPos;

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *
		gridX = x;
		gridY = y;
		if(obstacles!="")
			obstaclesPos=obstacles.split("[(,)]");
	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		Character[] kretnje=new Character[command.length()];
		for(int i=0;i<kretnje.length;i++)
			kretnje[i]=command.charAt(i);

		for(int i=0;i<kretnje.length;i++){
			if(kretnje[i]=='f'){
				if(planetSide==side[0])
					if(planetY!=gridY){
						checkObs();
						planetY++;
					}else
						planetY=0;
				else if(planetSide==side[1])
					if(planetY!=0)
						planetY--;
					else
						planetY=3;
				else if(planetSide==side[2])
					if(planetX!=gridX)
						planetX++;
					else
						planetX=0;
				else if(planetSide==side[3])
					if(planetX!=0)
						planetX--;
					else
						planetX=3;
			}else if(kretnje[i]=='b'){
				if(planetSide==side[0])
					if(planetY!=0)
						planetY--;
					else
						planetY=3;
				else if(planetSide==side[1])
					if(planetY!=gridY)
						planetY++;
					else
						planetY=0;
				else if(planetSide==side[2])
					if(planetX!=0)
						planetX--;
					else
						planetX=3;
				else if(planetSide==side[3])
					if(planetX!=gridX)
						planetX++;
					else
						planetX=0;
			}else if(kretnje[i]=='r'){
				RotateToRight();
			}else if(kretnje[i]=='l'){
				RotateToLeft();
			}
		}

		return "("+planetX+","+planetY+")";
	}

	public void RotateToRight(){
		if(planetSide==side[0]){
			planetSide=side[2];
		}else if(planetSide==side[2]){
			planetSide=side[1];
		}else if(planetSide==side[1]){
			planetSide=side[3];
		}else if(planetSide==side[3]){
			planetSide=side[0];
		}
	}

	public void RotateToLeft(){
		if(planetSide==side[0]){
			planetSide=side[3];
		}else if(planetSide==side[3]){
			planetSide=side[1];
		}else if(planetSide==side[1]){
			planetSide=side[2];
		}else if(planetSide==side[2]){
			planetSide=side[0];
		}
	}

	public void checkObs() throws PlanetExplorerException{
		if(planetY==Integer.parseInt(obstaclesPos[1])&&planetX==Integer.parseInt(obstaclesPos[0]))
			throw new PlanetExplorerException();
	}

}
