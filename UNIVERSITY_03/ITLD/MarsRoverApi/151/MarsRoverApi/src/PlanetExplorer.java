import java.util.ArrayList;





public class PlanetExplorer {
	int x, y;
	int pos_x, pos_y;
	String direction = "N";

	ArrayList<int[]> obstacles;
	String obstaclesHit = "";

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		if(obstacles != null){

			this.obstacles = new ArrayList<int[]>();

			String[] obstaclesArray = obstacles.split("[-\\t,;.?!:@\\[\\](){}_*			int i = 0;
			while (i < obstaclesArray.length){
				if(obstaclesArray[i].equals("")){
					while (obstaclesArray[i].equals("") && i < obstaclesArray.length)
						i++;
				}

				int obs_x = Integer.parseInt(obstaclesArray[i]);
				i++;
				int obs_y = Integer.parseInt(obstaclesArray[i]);
				i++;
				this.obstacles.add(new int[]{obs_x, obs_y});
			}
		}
		this.x = x;
		this.y = y;
	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		for (int i = 0; i < command.length(); i++){
			if (command.charAt(i) == 'f'){
				if(checkForObstacles(command.charAt(i))){
					if(direction == "N"){
						pos_y++;
					} else if (direction == "S"){
						pos_y--;
					} else if (direction =="E"){
						pos_x++;
					} else {
						pos_x--;
					}
				}
			} else if (command.charAt(i) == 'b'){
				if(checkForObstacles(command.charAt(i))){
					if(direction == "N"){
						pos_y--;
					} else if (direction == "S"){
						pos_y++;
					} else if (direction =="E"){
						pos_x--;
					} else {
						pos_x++;
					}
				}
			}
			else if (command.charAt(i) =='l' || command.charAt(i) == 'r'){
				changeDirection(command.charAt(i));
			}
			if (pos_x == x + 1) {
				pos_x = 0;
			} 
			if (pos_x == -1){
				pos_x = x;
			}
			if (pos_y == y + 1){
				pos_y = 0;
			}
			if (pos_y == -1){
				pos_y = y;
			}
		}

		return this.toString();
	}

	private void changeDirection(char side){
		if (side == 'l'){
			if (direction=="N")
				direction="W";
			else if (direction == "W")
				direction ="S";
			else if (direction == "S")
				direction ="E";
			else if (direction =="E")
				direction = "N";
		} else if (side == 'r'){
			if (direction=="N")
				direction="E";
			else if (direction == "W")
				direction ="N";
			else if (direction == "S")
				direction ="W";
			else if (direction =="E")
				direction = "S";
		}
	}

	private boolean checkForObstacles(char c){

		if (this.obstacles == null)
			return true;
		int check_x = pos_x;
		int check_y = pos_y;
		if (c == 'f'){
			if (direction == "N"){
				check_y++;
			} else if (direction == "S"){
				check_y--;
			} else if (direction =="E"){
				check_x++;
			} else {
				check_x--;
			}

		} else if (c == 'b'){
			if(direction == "N"){
				check_y--;
			} else if (direction == "S"){
				check_y++;
			} else if (direction =="E"){
				check_x--;
			} else {
				check_x++;
			}
		}


		for (int[] obstacle : this.obstacles){
			if (obstacle[0] == check_x && obstacle[1] == check_y){
				String newObstacle = "(" + obstacle[0] + ", " + obstacle[1] + ")";
				obstaclesHit += newObstacle;
				return false;
			}
		}
		return true;
	}

	public String toString(){
		return "(" + pos_x + ", " + pos_y +", " + direction + ")";
	}
}
