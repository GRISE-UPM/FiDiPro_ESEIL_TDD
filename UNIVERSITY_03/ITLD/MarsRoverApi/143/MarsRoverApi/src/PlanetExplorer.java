import java.awt.List;





public class PlanetExplorer {
	public int x=0;
	public int y=0;
	public String obstacles;
	public int[] explorer = {0,0};
	public char facing = 'N';
	int[] coordinatesOfObstacles;
	public boolean moving = true;

	public PlanetExplorer(int x, int y, String obstacles){

		this.x = x;
		this.y = y;
		this.obstacles = obstacles;
		getObstacles(obstacles);



	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}

	public String executeCommand(String command){

		char[] commandArray = command.toCharArray();
		for(int i = 0; i<commandArray.length; i++){
			if(commandArray[i] == 'f'){
				if(facing == 'N'){

					explorer[1]++;
					changeGridSide('f');
				}else if(facing =='S'){

					explorer[1]--;
					changeGridSide('f');
				}else if(facing == 'W'){

					explorer[0]++;
					changeGridSide('f');
				}else if(facing == 'E'){

					explorer[0]--;
					changeGridSide('f');
				}
			}else if(commandArray[i] == 'b'){
				if(facing == 'N'){

					explorer[1]--;
					changeGridSide('b');
				}else if(facing =='S'){

					explorer[1]++;
					changeGridSide('b');
				}else if(facing == 'W'){

					explorer[0]--;
					changeGridSide('b');
				}else if(facing == 'E'){

					explorer[0]++;
					changeGridSide('b');
				}
			}
			else if(commandArray[i] == 'l'){
				changeFacing('l');
			}
			else if(commandArray[i] == 'r'){
				changeFacing('r');
			}
		}


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return explorer[0]+", "+explorer[1]+", "+ facing;
	}

	public void getObstacles(String obstacles){

		String helpReplace = obstacles.replace("(","");
		String helpReplace1 = helpReplace.replace(",","");
		String helpReplace2 = helpReplace1.replace(")","");
		char[] replacer = helpReplace2.toCharArray();
		coordinatesOfObstacles=new int[replacer.length];
		for(int i=0;i<replacer.length;i++){
			coordinatesOfObstacles[i] = Integer.parseInt(String.valueOf(replacer[i]));
		}
	}

	public char changeFacing(char changeDirection){
		if(changeDirection == 'r'){
			if(facing == 'N')
				return facing = 'W';
			else if(facing == 'W')
				return facing = 'S';
			else if(facing == 'S')
				return facing = 'E';
			else if(facing == 'E')
				return facing = 'N';
		}
		else if(changeDirection == 'l'){
			if(facing == 'N')
				return facing = 'E';
			else if(facing == 'E')
				return facing = 'S';
			else if(facing == 'S')
				return facing = 'W';
			else if(facing == 'W')
				return facing = 'N';
		}
		return facing;
	}

	public void changeGridSide(char command){
		if((command == 'f' && facing == 'N')){
			if(explorer[1] == 101)
				explorer[1] = 0;

		}else if((command == 'f' && facing == 'S')){
			if(explorer[1] == -1)
				explorer[1] = 100;
		}else if(command=='f' && facing == 'W'){
			if(explorer[0] == 101)
				explorer[0] = 0;
		}else if(command=='f' && facing == 'E'){
			if(explorer[0] == -1)
				explorer[0] = 100;
		}else if(command=='b' && facing == 'N'){
			if(explorer[1] == -1)
				explorer[1] = 100;
		}else if(command=='b' && facing == 'S'){
			if(explorer[1] == 101)
				explorer[1] = 0;
		}else if(command=='b' && facing == 'W'){
			if(explorer[0] == -1)
				explorer[0] = 100;
		}
		else if(command=='b' && facing == 'E'){
			if(explorer[0] == 101)
				explorer[0] = 0;
		}
	}

	public void checkForObstacles(char command){
		for(int i = 0; i<coordinatesOfObstacles.length;i=i+2){
			 int[] checking = {coordinatesOfObstacles[i],coordinatesOfObstacles[i+1]};
			 if((command == 'f' && facing == 'N')){
					if(explorer[1]+1 == checking[0]||explorer[1]+1 == checking[1])
						moving = false;

				}else if((command == 'f' && facing == 'S')){
					if(explorer[1] == -1)
						explorer[1] = 100;
				}else if(command=='f' && facing == 'W'){
					if(explorer[0] == 101)
						explorer[0] = 0;
				}else if(command=='f' && facing == 'E'){
					if(explorer[0] == -1)
						explorer[0] = 100;
				}else if(command=='b' && facing == 'N'){
					if(explorer[1] == -1)
						explorer[1] = 100;
				}else if(command=='b' && facing == 'S'){
					if(explorer[1] == 101)
						explorer[1] = 0;
				}else if(command=='b' && facing == 'W'){
					if(explorer[0] == -1)
						explorer[0] = 100;
				}
				else if(command=='b' && facing == 'E'){
					if(explorer[0] == 101)
						explorer[0] = 0;
				}
		}
	}
}
