package tdd.training.paf;


public class MarsRover {

	private int X;
	private int Y;
	private String Obs;

	public MarsRover(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)" with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.X = x;
		this.Y = y;
		this.Obs = obstacles;
	}

	public static void main(String args[]) throws Exception {
		MarsRover mr = new MarsRover(2, 2, "(0,2)");
		String str = mr.executeCommand("ffrf", mr.X, mr.Y, mr.Obs);
		System.out.println(str);
	}
	
	public static String executeCommand(String command, int X, int Y, String obstacles) throws Exception {
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)"  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		MarsRover mr = new MarsRover(X, Y, obstacles);

		String[] commands = command.toLowerCase().split("");
		Position newPos = new Position(0, 0, "N");
		for(int i=0; i<commands.length; i++){
			switch(commands[i]){
				case "f":{
					newPos = mr.getCurrentPosition(newPos, "f", X, Y, obstacles);
					break;
				}
				case "b":{
					newPos = mr.getCurrentPosition(newPos, "b", X, Y, obstacles);
					break;
				}
				case "r":{
					newPos = mr.getCurrentPosition(newPos, "r", X, Y, obstacles);
					break;
				}
				case "l":{
					newPos = mr.getCurrentPosition(newPos, "l", X, Y, obstacles);
					break;
				}
				default:{
					throw new Exception("Unknown command requested "+commands[i]);
				}
			}
		}

		System.out.println(newPos.toString()+obstacles);
		 return newPos.toString()+obstacles;
	}

	public Position getCurrentPosition(Position position, String command, int X, int Y, String obstacles) {
		Position pos = new Position(position.getX(), position.getY(), position.getFacing());
		int x = position.getX();
		int y= position.getY();

		int xX = 0;
		int yY = 0;
		String facing = position.getFacing();
		if (command.equals("r")) {
			switch (facing) {
				case "N": {
					pos.setFacing("E");
					break;
				}
				case "E": {
					pos.setFacing("S");
					break;
				}
				case "S": {
					pos.setFacing("W");
					break;
				}
				case "W": {
					pos.setFacing("N");
					break;
				}

			}
		} else if (command.equals("l")) {
			switch (facing) {
				case "N": {
					pos.setFacing("W");
					break;
				}
				case "W": {
					pos.setFacing("S");
					break;
				}
				case "S": {
					pos.setFacing("E");
					break;
				}
				case "E": {
					pos.setFacing("N");
					break;
				}
			}
		} else if (command.equals("f")) {
			switch (facing) {
				case "N": {
					if (y + 1 <= Y)
						yY = y+1;
					else yY = 0;
					if(!obstacles.contains("("+pos.getX()+","+yY+")")) {
						pos.setY(yY);
					}
					break;
				}
				case "W": {
					if(x-1 >= 0)
						xX = x-1;
					else
						xX = X;

					if(!obstacles.contains("("+xX+","+pos.getY()+")")) {
						pos.setX(xX);
					}
					break;
				}
				case "S": {
					if(y-1 >= 0)
						yY  = y-1;
					else
					yY = Y;
					if(!obstacles.contains("("+pos.getX()+","+yY+")")) {
						pos.setY(yY);
					}
					break;
				}
				case "E": {
					if(x+1 <= X)
						xX = x+1;
					else xX = 0;
					if(!obstacles.contains("("+xX+","+pos.getY()+")")) {
						pos.setX(xX);
					}
					break;
				}
			}
		} else if (command.equals("b")) {
			switch (facing) {
				case "N": {
					if(y-1 >= 0)
						yY = y-1;
					else yY = Y;

					if(!obstacles.contains("("+pos.getX()+","+yY+")")) {
						pos.setY(yY);
					}
					break;
				}
				case "W": {
					if(x+1 <= X)
						pos.setX(x + 1);
					else pos.setX(0);

					if(!obstacles.contains("("+xX+","+pos.getY()+")")) {
						pos.setX(xX);
					}
					break;
				}
				case "S": {
					if(y+1 <= Y)
						yY = y+1;
					else yY = 0;

					if(!obstacles.contains("("+pos.getX()+","+yY+")")) {
						pos.setY(yY);
					}
					break;
				}
				case "E": {
					if(x-1 >= 0)
						xX = x-1;
					else
						xX = X;

					if(!obstacles.contains("("+xX+","+pos.getY()+")")) {
						pos.setX(xX);
					}
					break;
				}
			}
		}
		return pos;
	}
}
