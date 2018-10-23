




public class PlanetExplorer {
	int gridX,gridY;
	int voziloX,voziloY;
	String strana;
	String strane[] = {"n", "e", "s", "w"};
	int intStrane = 0;
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.gridX = x;
		this.gridY = y;
		voziloX = 0;
		voziloY = 0;
		strana = "n";
		intStrane = 0;
	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		for(int i = 0; i < command.length(); i++){
			String c;
			try {
				c = command.substring(i, i+1);

				if(c.equals("f")){
					switch(intStrane){
					case 0:
						voziloY++;
						break;
					case 1:
						voziloX++;
						break;
					case 2:
						voziloY--;
						break;
					case 3:
						voziloX--;
						break;
					}



				}else if (c.equals("b")){

					switch(intStrane){
					case 0:
						voziloY--;
						break;
					case 1:
						voziloX--;
						break;

					case 2:
						voziloY++;
						break;
					case 3:
						voziloX++;
						break;
					}


				}else if(c.equals("r")){
					intStrane++;
					intStrane = intStrane % 4;
				}else if (c.equals("l")){
					intStrane--;
					if(intStrane == - 1)
						intStrane = 3;
				}else{
					throw new PlanetExplorerException();
				}

			} catch (Exception e) {
				throw new PlanetExplorerException();

			}


			proveri();
		}

		return "(" + voziloX + "," + voziloY + "," + strane[intStrane] + ")";
	}

	public void proveri(){
		if(voziloY == gridY){
			voziloY = 0;
		}
		if(voziloX == gridX){
			voziloX = 0;
		}
		if(voziloX == -1){
			voziloX = gridX - 1;
		}
		if(voziloY == -1){
			voziloY = gridY - 1;
		}
	}

	public String getGridSize() {

		return gridX + "x" + gridY;
	}

	public String getVoziloKoor() {

		return "(" + voziloX + "," + voziloY + ")";
	}

	public String getVoziloStrana() {

		return strana;
	}
}
