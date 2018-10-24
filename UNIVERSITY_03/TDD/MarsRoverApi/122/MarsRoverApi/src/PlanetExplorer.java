




public class PlanetExplorer {
	private int x;
	private int y;
	private String obstacle;
	private String direction;
	private int vehicleX;
	private int vehicleY;


	public PlanetExplorer(int x, int y, String obstacles){
		this.x = x;
		this.y = y;
		this.obstacle = obstacle;
		this.direction = "n";


	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}

	public String executeCommand(String command) throws PlanetExplorerException{
		char[] niz = command.toCharArray();


		for(char i: niz){
			switch(i){
				case 'r': rotate(i); break;
				case 'l': rotate(i); break;
				case 'f': moveForward();break;
				case 'b': moveBack();break;
				default: throw new PlanetExplorerException();
			}
		}



		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return "(" + vehicleX + "," + vehicleY + "," + direction + ")";
	}









	public void moveForward(){
		if(direction == "n"){
			if(vehicleY == y){
				vehicleY = 0;
			} else {
				vehicleY++;
			}
		} else if (direction == "e"){
			if(vehicleX == x){
				vehicleX = 0;
			} else {
				vehicleX++;
			}

		} else if (direction == "s"){
			if(vehicleY == 0){
				vehicleY = y;
			} else {
				vehicleY--;
			}
		} else {
			if(vehicleX == 0){
				vehicleX = x;
			} else {
				vehicleX--;
			}			
		}
	}

	public void moveBack(){
		if(direction == "n"){
			if(vehicleY == 0){
				vehicleY = y;
			} else {
				vehicleY--;
			}
		} else if (direction == "e"){
			if(vehicleX == 0){
				vehicleX = x;
			} else {
				vehicleX--;
			}
		} else if (direction == "s"){
			if(vehicleY == y){
				vehicleY = 0;
			} else {
				vehicleY++;
			}
		} else if (direction == "w"){
			if(vehicleX == x){
				vehicleX = 0;
			} else {
				vehicleX++;
			}
		}

	}



	public void rotate(char i){
		switch(i){
			case 'r':
				if(direction == "n"){
					direction = "e";
				} else if (direction == "e"){
					direction = "s";
				} else if (direction == "s"){
					direction = "w";
				} else {
					direction = "n";
				}
			break;

			case 'l':
				if(direction == "n"){
					direction = "w";
				} else if(direction == "w"){
					direction = "s";
				} else if (direction == "s"){
					direction = "e";
				} else {
					direction = "n";
				}
			break;
		}
	}


	public void setVehicleY(int vehicleY) {
		this.vehicleY = vehicleY;
	}

	public void setVehicleX(int vehicleX) {
		this.vehicleX = vehicleX;
	}



}
